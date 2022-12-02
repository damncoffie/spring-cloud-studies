package com.cloud.sentence.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("SUBJECT-APP")
public interface SubjectClient {

    @GetMapping("/")
    String getWord();
}
