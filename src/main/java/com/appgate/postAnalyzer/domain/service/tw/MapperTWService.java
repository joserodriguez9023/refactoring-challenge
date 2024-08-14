package com.appgate.postAnalyzer.domain.service.tw;

import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import com.appgate.postAnalyzer.domain.dto.AnalysisSocialMentionResponseDto;
import com.appgate.postAnalyzer.infrastructure.db.entities.AnalyzedTweet;

import java.time.LocalDateTime;

public class MapperTWService {


    private static final String TYPE_ACCOUNT = "Twitter";

    public static AnalyzedTweet fromScoreSMBOToAnalyzedTweet(ScoreSMBO scoreSMBO) {
        return AnalyzedTweet.builder()
                .score(scoreSMBO.getScore())
                .account(scoreSMBO.getSocialMentionDto().getTwitterAccount())
                .tweetUrl(scoreSMBO.getSocialMentionDto().getTwitterUrl())
                .message(scoreSMBO.getSocialMentionDto().getMessage())
                .level(scoreSMBO.getLevel())
                .build();
    }

    public static AnalysisSocialMentionResponseDto fromAnalyzedTweetToAnalysisSocialMentionResponseDto(AnalyzedTweet analyzedTweet) {
        return AnalysisSocialMentionResponseDto.builder()
                .analysisDate(String.valueOf(LocalDateTime.now()))
                .typeAccount(TYPE_ACCOUNT)
                .nameAccount(analyzedTweet.getAccount())
                .isSaved(true)
                .level(analyzedTweet.getLevel())
                .score(analyzedTweet.getScore())
                .build();
    }
}
