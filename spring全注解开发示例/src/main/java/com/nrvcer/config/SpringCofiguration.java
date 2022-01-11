package com.nrvcer.config;

import org.springframework.context.annotation.*;

// 标志该类是Spring的核心配置类
@Configuration
// 组件扫描器，<context:component-scan base-package="com.nrvcer"></context:component-scan>
@ComponentScan(value = "com.nrvcer")
// 导入其他配置，<import resource=""/>
@Import({DataSourceConfiguration.class})
public class SpringCofiguration {

}
