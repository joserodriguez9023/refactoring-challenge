package com.appgate.postAnalyzer.domain.service.processor;

import com.appgate.postAnalyzer.domain.bo.SourceSMBO;
import com.appgate.postAnalyzer.domain.service.fb.FBBuildMessage;
import com.appgate.postAnalyzer.domain.service.tw.TWBuildMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BuilderMessageImpl implements BuilderMessageService {

    @Override
    public Mono<SourceSMBO> buildMessage(SourceSMBO sourceSocialMentionBO) {
        return Mono.just(processMessage(sourceSocialMentionBO));

    }

    private SourceSMBO processMessage(SourceSMBO sourceSocialMentionBO) {
        if (sourceSocialMentionBO.isFacebook) {
            sourceSocialMentionBO.getSocialMentionDto().setMessage(
                    FBBuildMessage.buildMessage(sourceSocialMentionBO)
            );
        } else {
            sourceSocialMentionBO.getSocialMentionDto().setMessage(
                    TWBuildMessage.buildMessage(sourceSocialMentionBO)
            );
        }
        return sourceSocialMentionBO;
    }



}
