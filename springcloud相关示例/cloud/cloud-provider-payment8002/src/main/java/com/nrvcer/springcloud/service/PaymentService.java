package com.nrvcer.springcloud.service;

import com.nrvcer.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public long create(Payment payment);
    public Payment getPaymentById(Long id);
}
