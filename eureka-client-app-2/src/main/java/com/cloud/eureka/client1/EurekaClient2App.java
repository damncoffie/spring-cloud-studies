package com.cloud.eureka.client1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClient2App {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient2App.class, args);
    }
}
