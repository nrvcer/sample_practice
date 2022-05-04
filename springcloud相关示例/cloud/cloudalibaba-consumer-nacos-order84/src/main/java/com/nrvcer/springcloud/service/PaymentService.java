package com.nrvcer.springcloud.service;

import com.nrvcer.springcloud.entities.CommonResult;
import com.nrvcer.springcloud.entities.Payment;
import com.nrvcer.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// 使用 fallback 方式是无法获取异常信息的,
// 如果想要获取异常信息，可以使用 fallbackFactory参数
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)//调用中关闭9003服务提供者
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
