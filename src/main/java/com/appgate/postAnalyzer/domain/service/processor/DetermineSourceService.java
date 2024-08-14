package com.appgate.postAnalyzer.domain.service.processor;

import com.appgate.postAnalyzer.domain.bo.SourceSMBO;
import com.appgate.postAnalyzer.domain.dto.SocialMentionDto;
import reactor.core.publisher.Mono;

public interface DetermineSourceService {
    Mono<SourceSMBO> determineSourceSocialMention(SocialMentionDto  socialMentionDto);
}
