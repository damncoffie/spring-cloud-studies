package com.cloud.sentence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SentenceApp {

    public static void main(String[] args) {
        SpringApplication.run(SentenceApp.class, args);
    }
}
