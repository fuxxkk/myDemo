package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurakaRegisterApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurakaRegisterApplication.class, args);
        System.out.println("注册中心:http://localhost:8761/");
    }
}
