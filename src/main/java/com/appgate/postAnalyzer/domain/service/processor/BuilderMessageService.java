package com.appgate.postAnalyzer.domain.service.processor;

import com.appgate.postAnalyzer.domain.bo.SourceSMBO;
import reactor.core.publisher.Mono;

public interface BuilderMessageService {
    Mono<SourceSMBO> buildMessage(SourceSMBO sourceSocialMentionBO);

}
