package com.nrvcer.service.impl;

import com.nrvcer.service.SomeService;

// 目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void dosome(String name, Integer age) {
        // 需求：给dosome方法增加一个功能，在dosome()执行之前，输出方法的执行时间
        System.out.println("==目标方法dosome()执行==");
    }

    @Override
    public String doOnther(String name, Integer age) {
        System.out.println("==目标方法doOnther()执行==");
        return "test";
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("==执行了业务方法doFirst()==");
        return "doFirst";
    }
}
