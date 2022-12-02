package com.cloud.sentence.service.impl;

import com.cloud.sentence.clients.AdjectiveClient;
import com.cloud.sentence.clients.SubjectClient;
import com.cloud.sentence.clients.VerbClient;
import com.cloud.sentence.service.WordService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {

    private AdjectiveClient adjectiveClient;

    private SubjectClient subjectClient;

    private VerbClient verbClient;

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackAdjective")
    public String getAdjective() {
        return adjectiveClient.getWord();
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackSubject")
    public String getSubject() {
        return subjectClient.getWord();
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackVerb")
    public String getVerb() {
        return verbClient.getWord();
    }

    private String getFallbackAdjective() {
        return "default";
    }

    private String getFallbackSubject() {
        return "defaulty";
    }

    private String getFallbackVerb() {
        return "defaulted";
    }
}
