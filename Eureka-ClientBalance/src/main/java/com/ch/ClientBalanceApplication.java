package com.ch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker //开启容错功能,进行容错管理
@SpringBootApplication
@EnableDiscoveryClient
public class ClientBalanceApplication {

    @LoadBalanced //开启负载均衡客户端
    @Bean //注册一个具有容错功能的RestTemplate
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientBalanceApplication.class, args);
    }
}
