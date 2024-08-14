package com.appgate.postAnalyzer.domain.service.processor;

import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import com.appgate.postAnalyzer.domain.bo.SourceSMBO;
import reactor.core.publisher.Mono;

public interface AnalyzerSMService {
    Mono<ScoreSMBO> qualifySocialMention(SourceSMBO sourceSocialMentionBO);
}
