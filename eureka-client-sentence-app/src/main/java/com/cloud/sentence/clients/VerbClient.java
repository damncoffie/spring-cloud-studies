package com.cloud.sentence.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("VERB-APP")
public interface VerbClient {

    @GetMapping("/")
    public String getWord();
}
