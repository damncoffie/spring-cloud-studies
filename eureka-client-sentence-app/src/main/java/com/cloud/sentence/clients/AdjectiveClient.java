package com.cloud.sentence.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("ADJECTIVE-APP")
public interface AdjectiveClient {

    @GetMapping("/")
    String getWord();
}
