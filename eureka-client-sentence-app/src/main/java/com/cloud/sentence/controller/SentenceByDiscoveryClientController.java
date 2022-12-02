package com.cloud.sentence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class SentenceByDiscoveryClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/sentence-by-discovery-client")
    public String getSentence() {
        return getWordUsingDiscoveryClient("SUBJECT-APP") + " "
                + getWordUsingDiscoveryClient("VERB-APP") + " "
                + getWordUsingDiscoveryClient("ADJECTIVE-APP");
    }

    private String getWordUsingDiscoveryClient(String service) {
        List<ServiceInstance> list = discoveryClient.getInstances(service);
        if (list != null && list.size() > 0) {
            URI uri = list.get(0).getUri();
            if (uri != null) {
                return (new RestTemplate()).getForObject(uri, String.class);
            }
        }
        return null;
    }
}
