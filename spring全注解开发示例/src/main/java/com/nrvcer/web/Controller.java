package com.nrvcer.web;

import com.alibaba.druid.pool.DruidDataSource;
import com.nrvcer.config.SpringCofiguration;
import com.nrvcer.service.UserService;
import jdk.jfr.StackTrace;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Controller {
    public static void main(String[] args) throws SQLException {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringCofiguration.class);
        UserService service = (UserService)app.getBean("userService");
        service.save();

        DruidDataSource dataSource = (DruidDataSource)app.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }
}
