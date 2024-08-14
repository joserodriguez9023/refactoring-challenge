package com.appgate.postAnalyzer.domain.service.processor;

import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import com.appgate.postAnalyzer.domain.dto.AnalysisSocialMentionResponseDto;
import reactor.core.publisher.Mono;

public interface SaverSocialMentionService {
    Mono<AnalysisSocialMentionResponseDto> saveSocialMention(ScoreSMBO scoreSocialMentionBO);

}
