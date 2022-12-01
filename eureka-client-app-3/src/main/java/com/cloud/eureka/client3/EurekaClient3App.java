package com.cloud.eureka.client3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClient3App {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient3App.class, args);
    }
}
