package com.nrvcer.springcloud.service.impl;

import com.nrvcer.springcloud.dao.PaymentDao;
import com.nrvcer.springcloud.entities.Payment;
import com.nrvcer.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public long create(Payment payment) {
        paymentDao.create(payment);
        return payment.getId();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
