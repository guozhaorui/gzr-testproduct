package com.test.appA;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan
public class ApplicationA {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationA.class, args);
    }

}