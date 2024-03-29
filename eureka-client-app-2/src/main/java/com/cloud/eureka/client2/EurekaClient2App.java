package com.cloud.eureka.client2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClient2App {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient2App.class, args);
    }
}
