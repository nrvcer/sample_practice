package com.nrvcer.web;

import com.nrvcer.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Controller {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = (UserService)app.getBean("userService");
        // username:root
        // save running!
        service.save();
    }
}
