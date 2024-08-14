package com.appgate.postAnalyzer.domain.ports.in;

import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import com.appgate.postAnalyzer.domain.dto.AnalysisSocialMentionResponseDto;
import reactor.core.publisher.Mono;

public interface ATweetPersistencePort {
    Mono<AnalysisSocialMentionResponseDto> insertTWSocialMention(ScoreSMBO scoreSocialMentionBO);

}
