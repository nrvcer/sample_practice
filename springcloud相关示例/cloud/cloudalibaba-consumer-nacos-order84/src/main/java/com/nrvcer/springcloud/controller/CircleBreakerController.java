package com.nrvcer.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.nrvcer.springcloud.entities.CommonResult;
import com.nrvcer.springcloud.entities.Payment;
import com.nrvcer.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    // SentinelResource不配置fallback属性和blockHandler属性
//    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    public CommonResult<Payment> fallback(@PathVariable Long id)
//    {
//        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id,CommonResult.class,id);
//
//        if (id == 4) {
//            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
//        }else if (result.getData() == null) {
//            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
//        }
//
//        return result;
//    }

    // SentinelResource只配置fallback属性
//    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback负责业务异常
//    public CommonResult<Payment> fallback(@PathVariable Long id)
//    {
//        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id,CommonResult.class,id);
//
//        if (id == 4) {
//            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
//        }else if (result.getData() == null) {
//            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
//        }
//
//        return result;
//    }
//    public CommonResult handlerFallback(@PathVariable  Long id,Throwable e) {
//        Payment payment = new Payment(id,"null");
//        return new CommonResult<>(444,"兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
//    }

    // SentinelResource只配置blockHandler属性
//    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler负责在sentinel里面配置的降级限流
//    public CommonResult<Payment> fallback(@PathVariable Long id)
//    {
//        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id,CommonResult.class,id);
//        if (id == 4) {
//            throw new IllegalArgumentException ("非法参数异常....");
//        }else if (result.getData() == null) {
//            throw new NullPointerException ("NullPointerException,该ID没有对应记录");
//        }
//        return result;
//    }
//    public CommonResult blockHandler(@PathVariable  Long id, BlockException blockException) {
//        Payment payment = new Payment(id,"null");
//        return new CommonResult<>(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
//    }

    // SentinelResource配置blockHandler属性和fallback属性
    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",
            fallback = "handlerFallback",
            blockHandler = "blockHandler",
            // 假如报IllegalArgumentException异常，则不再有fallback方法兜底，没有降级效果
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id)
    {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id,CommonResult.class,id);
        if (id == 4) {
            throw new IllegalArgumentException ("非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录");
        }
        return result;
    }
    public CommonResult handlerFallback(@PathVariable  Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"fallback,无此流水,exception  "+e.getMessage(),payment);
    }
    public CommonResult blockHandler(@PathVariable  Long id,BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }

    //==================OpenFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/openfeign/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id)
    {
        if(id == 4)
        {
            throw new RuntimeException("没有该id");
        }
        return paymentService.paymentSQL(id);
    }
}
