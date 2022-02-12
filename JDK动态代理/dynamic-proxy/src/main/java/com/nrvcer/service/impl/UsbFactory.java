package com.nrvcer.service.impl;

import com.nrvcer.service.UsbSell;

/**
 * 定义目标接口实现类
 */
public class UsbFactory implements UsbSell {
    @Override
    public float sell(int amount) {
        return 90.0F;
    }
}
