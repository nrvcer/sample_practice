package com.nrvcer;

import com.nrvcer.handler.MyHandler;
import com.nrvcer.service.UsbSell;
import com.nrvcer.service.impl.UsbFactory;

import java.lang.reflect.Proxy;

public class ShopApplication {
    public static void main(String[] args) {
        // 创建调用处理器
        UsbFactory factory = new UsbFactory();
        MyHandler handler = new MyHandler(factory);
        // 创建JDK动态代理
        UsbSell taobao = (UsbSell)Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(),
                handler);
        float price = taobao.sell(1);
        System.out.println(price);
    }
}
