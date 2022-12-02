package com.cloud.sentence.service.impl;

import com.cloud.sentence.service.SentenceService;
import com.cloud.sentence.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {

    @Autowired
    private WordService wordService;

    @Override
    public String buildSentence() {

        return wordService.getAdjective() + " "
                + wordService.getSubject() + " "
                + wordService.getVerb();
    }
}
