package com.appgate.postAnalyzer.domain.service.processor;

import com.appgate.postAnalyzer.domain.bo.SourceSMBO;
import com.appgate.postAnalyzer.domain.dto.SocialMentionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DetermineSourceImpl implements DetermineSourceService {
    @Override
    public Mono<SourceSMBO> determineSourceSocialMention(SocialMentionDto socialMentionDto) {
        return Mono.just(SourceSMBO.builder().socialMentionDto(socialMentionDto)
                .isFacebook(determineSource(socialMentionDto)).build());
    }

    private Boolean determineSource(SocialMentionDto socialMentionDto){
        return socialMentionDto.getFacebookAccount() != null && !socialMentionDto.getFacebookAccount().trim().isEmpty();

    }
}
