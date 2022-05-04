package com.nrvcer.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.nrvcer.springcloud.dao"})
public class MyBatisConfig {

}
