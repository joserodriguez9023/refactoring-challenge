package com.appgate.postAnalyzer.domain.service.fb;

import com.appgate.postAnalyzer.domain.bo.SourceSMBO;

import java.util.Random;

public class FacebookAnalyzer {

    public static double calculateFacebookCommentsScore(String comments) {
        double score = new Random().nextDouble()*100;
        if(score < 50){
            return -100;
        }
        return 0;
    }

    public static double analyzePost(SourceSMBO sourceSocialMentionBO) {
        return new Random().nextDouble()*100;
    }
}
