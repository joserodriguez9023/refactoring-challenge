package com.appgate.postAnalyzer.domain.service.processor;

import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import reactor.core.publisher.Mono;

public interface CategorizerRiskService {
    Mono<ScoreSMBO> categorizeRiskLevelSocialMention(ScoreSMBO scoreSMBO);
}
