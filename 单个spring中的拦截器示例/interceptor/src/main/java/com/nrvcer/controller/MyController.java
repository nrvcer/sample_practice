package com.nrvcer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MyController {
    @RequestMapping(value="/some.do")
    public ModelAndView doSome(HttpSession session, String name, Integer age) {
        System.out.println("控制器的doSome方法执行");

        // 添加一个临时数据
        session.setAttribute("attr", "在controller中添加的临时数据");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myname", name);
        modelAndView.addObject("myage", age);
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
