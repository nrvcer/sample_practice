package com.nrvcer.handler;

import com.nrvcer.exception.AgeException;
import com.nrvcer.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*
@ControllerAdvice注解：表示当前类是异常的处理类，给controller类增加功能的
位置：在类的上面
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    // 定义处理异常的方法，当异常发生后，执行这个方法

    /**
     * 处理姓名异常
     * @ExceptionHandler:表示此方法处理异常
     * 属性value：表示异常的类型
     *位置：方法的上面
     * e:即为控制器中抛出异常的对象
     */
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception e) {
        /*
        发生异常：
        1. 记录异常，记录到日志文件
        2. 发送通知，邮件，短信等
        3. 给用户友好的提示
         */
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tips", "姓名非法");
        modelAndView.addObject("exception", e.getMessage());
        modelAndView.setViewName("nameError");
        return modelAndView;
    }
    // 处理年龄异常
    @ExceptionHandler(value= AgeException.class)
    public ModelAndView doAgeException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tips", "年龄不能小于0大于120");
        modelAndView.addObject("exception", e.getMessage());
        modelAndView.setViewName("ageError");
        return modelAndView;
    }
    // 处理其他异常，NameException,AgeException以外的异常
    @ExceptionHandler
    public ModelAndView doOtherException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tips", "发生其他异常!");
        modelAndView.addObject("exception", e.getMessage());
        modelAndView.setViewName("defaultError");
        return modelAndView;
    }
}
