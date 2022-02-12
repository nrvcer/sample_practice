package com.nrvcer.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;
import java.util.Locale;

/**
 * @Aspect：AspectJ框架中的注解
 * 作用：表示当前类是切面类
 */
@Aspect
public class MyAspect {
    /**
     * 定义方法，方法是实现切面功能的
     * 方法的定义要求：
     * 1. 公共方法public
     * 2. 方法没有返回值
     * 3. 方法名称自定义
     * 4. 方法可以有参数，也可以没有参数。如果有参数，参数不是自定义的。
     */

    /**
     * @Before:前置通知注解
     * 属性value：表示切入点表达式，表示切面的功能执行的位置
     * 位置：方法的上面
     */
    // @Before(value = "execution(public void com.nrvcer.service.impl.SomeServiceImpl.dosome(String, Integer))")
    // @Before(value = "execution(void *..SomeServiceImpl.dosome(String, Integer))")
    // @Before(value = "execution( void *..SomeServiceImpl.do*(..))")
    // @Before(value = "execution( * *..SomeServiceImpl.do*(..))")
    // @Before(value = "execution(* *..*.*.*(..) )")
    @Before(value = "execution( * *..SomeServiceImpl.*(..))")
    public void oneAspect() {
        // 切面要执行的功能代码
        System.out.println("前置通知，切面功能是在目标方法执行之前输出时间：" + new Date());
    }
    // 所有通知方法都可以包含JoinPoint参数
    // JoinPoint参数表示连接点方法
    @Before(value="execution(* *..*.*.*(..))")
    public void twoAspect(JoinPoint joinPoint) {
        // JoinPoint参数能够获取到方法的定义，方法的参数等信息

        // 连接点方法的定义：void com.nrvcer.service.SomeService.dosome(String,Integer)
        System.out.println("连接点方法的定义：" + joinPoint.getSignature());
        // 连接点方法的参数个数：2
        System.out.println("连接点方法的参数个数：" + joinPoint.getArgs().length);
        // 方法参数的信息
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
        System.out.println("前置通知，在目标方法之前执行输出日志");
    }
    @AfterReturning(value ="execution(String *..*.*.*(..))"
            ,returning = "result")
    public void threeAspect(Object result) {
        // 修改目标方法的执行结果
        if (result != null) {
            String str = (String)result;
            result = str.toUpperCase(Locale.ROOT);
        }
        System.out.println("后置通知，在目标方法之后执行的功能增强，例如执行事务处理," + result);
    }

    @Around(value = "execution(String *..*.*.*First(..))")
    public Object fourAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object obj = null;
        // 增强功能
        System.out.println("环绕通知：在目标方法之前执行的，例如输出日志");
        // 执行目标方法的调用。等同于method.invoke(target, args)
        obj = proceedingJoinPoint.proceed();
        // 增强功能
        System.out.println("环绕通知：在目标方法之后执行的，例如处理事务");
        // 返回目标方法的执行结果
        return obj;
    }
}

