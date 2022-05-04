package com.nrvcer.springcloud.controller;

import com.nrvcer.springcloud.entities.CommonResult;
import com.nrvcer.springcloud.entities.Payment;
import com.nrvcer.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        long result = paymentService.create(payment);
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,port" + port, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable(value = "id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果111：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询数据库成功,port" + port, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID为" + id, null);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String getServerPort() {
        return port;
    }
}
