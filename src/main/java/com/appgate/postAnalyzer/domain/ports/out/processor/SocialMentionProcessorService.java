package com.appgate.postAnalyzer.domain.ports.out.processor;

import com.appgate.postAnalyzer.domain.dto.AnalysisSocialMentionResponseDto;
import com.appgate.postAnalyzer.domain.dto.SocialMentionDto;
import reactor.core.publisher.Mono;

public interface SocialMentionProcessorService {
    Mono<AnalysisSocialMentionResponseDto> processSocialMention(SocialMentionDto socialMentionDto);
}
