package com.nrvcer.controller;

import com.nrvcer.exception.AgeException;
import com.nrvcer.exception.MyUserException;
import com.nrvcer.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    @RequestMapping(value="/some.do")
    public ModelAndView doSome(String name, Integer age) throws MyUserException {
        System.out.println("执行了doSome方法");
        ModelAndView modelAndView = new ModelAndView();

        // 抛出异常
        if ("中国".equals(name)) {
            throw new NameException("姓名非法!");
        }
        if (age == null || age <= 0 || age > 120 ) {
            throw new AgeException("年龄非法!");
        }

        modelAndView.addObject("myname", name);
        modelAndView.addObject("myage", age);
        modelAndView.setViewName("show");

        return modelAndView;
    }
}
