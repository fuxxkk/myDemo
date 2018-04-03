package com.ch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HelloWordServiceHiApplication {
	//test
	public static void main(String[] args) {
		SpringApplication.run(HelloWordServiceHiApplication.class, args);
	}
}
