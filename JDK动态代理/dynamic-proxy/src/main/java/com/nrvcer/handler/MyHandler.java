package com.nrvcer.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 定义调用处理程序
 */
public class MyHandler implements InvocationHandler {
    private Object target = null; // 目标对象

    public MyHandler() {
    }

    public MyHandler(Object target) {
        // 使用构造方法传入目标对象，给目标对象提供代理功能
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 执行目标方法
        Object ret = method.invoke(target, args);
        // 在目标方法执行之后，增强功能
        float price = (float)ret;
        ret =  price + 20;
        System.out.println("优惠活动！");
        return ret;
    }
}
