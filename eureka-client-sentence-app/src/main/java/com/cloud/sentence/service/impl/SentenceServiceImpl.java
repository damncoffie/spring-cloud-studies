package com.cloud.sentence.service.impl;

import com.cloud.sentence.clients.AdjectiveClient;
import com.cloud.sentence.clients.SubjectClient;
import com.cloud.sentence.clients.VerbClient;
import com.cloud.sentence.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {

    @Autowired
    private AdjectiveClient adjectiveClient;

    @Autowired
    private SubjectClient subjectClient;

    @Autowired
    private VerbClient verbClient;

    @Override
    public String buildSentence() {

        return adjectiveClient.getWord() + " "
                + subjectClient.getWord() + " "
                + verbClient.getWord();
    }
}
