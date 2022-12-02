package com.cloud.sentence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentenceController {

    @Autowired
    private RestTemplate restTemplate;
    // private DiscoveryClient discoveryClient;

    @Value("${lucky-word}")
    private String luckyWord;

    @GetMapping("/sentence")
    public @ResponseBody
    String getSentence() {
        return getWord("SUBJECT-APP") + " "
                + getWord("VERB-APP") + " "
                + getWord("ADJECTIVE-APP");
    }

    public String getWord(String service) {
        return restTemplate.getForObject("http://" + service, String.class);
//        List<ServiceInstance> list = discoveryClient.getInstances(service);
//        if (list != null && list.size() > 0) {
//            URI uri = list.get(0).getUri();
//            if (uri != null) {
//                return (new RestTemplate()).getForObject(uri, String.class);
//            }
//        }
//        return null;
    }

    @GetMapping("/getGitLuckyWord")
    public @ResponseBody String get() {
        return luckyWord;
    }
}
