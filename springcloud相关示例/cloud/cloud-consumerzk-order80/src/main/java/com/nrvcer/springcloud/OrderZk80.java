package com.nrvcer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

public class OrderZk80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZk80.class, args);
    }
}
