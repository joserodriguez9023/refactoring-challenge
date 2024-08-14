package com.appgate.postAnalyzer.domain.service.fb;

import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import com.appgate.postAnalyzer.domain.bo.SourceSMBO;
import com.appgate.postAnalyzer.domain.dto.AnalysisSocialMentionResponseDto;
import com.appgate.postAnalyzer.infrastructure.db.entities.AnalyzedFbPost;

import java.time.LocalDateTime;
import java.util.Random;

public class MapperFBService {


    private static final String TYPE_ACCOUNT = "Facebook";
    public static AnalyzedFbPost fromScoreSMBOToAnalyzedFbPost(ScoreSMBO scoreSMBO) {
        return AnalyzedFbPost.builder()
                .score(scoreSMBO.getScore())
                .account(scoreSMBO.getSocialMentionDto().getFacebookAccount())
                .level(scoreSMBO.getLevel())
                .message(scoreSMBO.getSocialMentionDto().getMessage())
                .build();
    }

    public static AnalysisSocialMentionResponseDto fromAnalyzedFbPostToAnalysisSocialMentionResponseDto(AnalyzedFbPost  analyzedFbPost) {
        return AnalysisSocialMentionResponseDto.builder()
                .analysisDate(String.valueOf(LocalDateTime.now()))
                .typeAccount(TYPE_ACCOUNT)
                .nameAccount(analyzedFbPost.getAccount())
                .isSaved(true)
                .level(analyzedFbPost.getLevel())
                .score(analyzedFbPost.getScore())
                .build();
    }
    public static AnalysisSocialMentionResponseDto fromScoreSMBOToAnalysisSocialMentionResponseDto(ScoreSMBO scoreSMBO) {
        return AnalysisSocialMentionResponseDto.builder()
                .analysisDate(String.valueOf(LocalDateTime.now()))
                .typeAccount(TYPE_ACCOUNT)
                .nameAccount(scoreSMBO.getSocialMentionDto().getFacebookAccount())
                .isSaved(false)
                .level(scoreSMBO.getLevel())
                .score(scoreSMBO.getScore())
                .build();
    }
}
