package com.appgate.postAnalyzer.domain.service.tw;

import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import com.appgate.postAnalyzer.domain.bo.SourceSMBO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TWAnalyzerImpl implements TWAnalyzerService {
    @Override
    public ScoreSMBO analyze(SourceSMBO sourceSocialMentionBO) {
        return ScoreSMBO.builder()
                .score(TwitterAnalyzer.analyzeTweet(sourceSocialMentionBO))
                .socialMentionDto(sourceSocialMentionBO.getSocialMentionDto())
                .isFacebook(sourceSocialMentionBO.getIsFacebook())
                .toSave(true).build();
    }

}
