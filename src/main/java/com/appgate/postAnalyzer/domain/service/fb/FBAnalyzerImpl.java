package com.appgate.postAnalyzer.domain.service.fb;

import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import com.appgate.postAnalyzer.domain.bo.SourceSMBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FBAnalyzerImpl implements FBAnalyzerService {

    private static final String COMMENTS = "comments:";

    @Override
    public ScoreSMBO analyze(SourceSMBO sourceSocialMentionBO) {

        boolean hasFacebookComments = !sourceSocialMentionBO.getSocialMentionDto().getFacebookComments().isEmpty();
        log.info(String.valueOf(!sourceSocialMentionBO.getSocialMentionDto().getFacebookComments().isEmpty()));
        if (hasFacebookComments){
            int index = sourceSocialMentionBO.getSocialMentionDto().getMessage().indexOf(COMMENTS);
            double score = FacebookAnalyzer.calculateFacebookCommentsScore(
                    sourceSocialMentionBO.getSocialMentionDto().getMessage().substring(index)
        );

        if (score <= -100) {
            return buildScoreSocialMention(sourceSocialMentionBO, 0, false);
        }
        }

        return executeAnalysis(sourceSocialMentionBO);
    }

    private ScoreSMBO executeAnalysis(SourceSMBO sourceSocialMentionBO) {
        return buildScoreSocialMention(sourceSocialMentionBO, FacebookAnalyzer.analyzePost(sourceSocialMentionBO), true);
    }

    private ScoreSMBO buildScoreSocialMention(SourceSMBO sourceSocialMentionBO, double score, boolean toSave) {
        return ScoreSMBO.builder()
                .score(score)
                .socialMentionDto(sourceSocialMentionBO.getSocialMentionDto())
                .isFacebook(sourceSocialMentionBO.getIsFacebook())
                .toSave(toSave)
                .build();
    }
}
