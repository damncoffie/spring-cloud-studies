package com.cloud.sentence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentenceByRibbonRestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String getSentence() {
        return getWordUsingRestTemplateHookedWithRibbon("SUBJECT-APP") + " "
                + getWordUsingRestTemplateHookedWithRibbon("VERB-APP") + " "
                + getWordUsingRestTemplateHookedWithRibbon("ADJECTIVE-APP");
    }

    private String getWordUsingRestTemplateHookedWithRibbon(String service) {
        return restTemplate.getForObject("http://" + service, String.class);
    }
}
