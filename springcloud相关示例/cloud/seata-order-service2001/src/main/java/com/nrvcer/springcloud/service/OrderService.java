package com.nrvcer.springcloud.service;

import com.nrvcer.springcloud.domain.Order;

public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
