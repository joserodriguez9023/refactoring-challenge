package com.appgate.postAnalyzer.domain.service.processor;

import com.appgate.postAnalyzer.domain.dto.AnalysisSocialMentionResponseDto;
import com.appgate.postAnalyzer.domain.dto.SocialMentionDto;
import com.appgate.postAnalyzer.domain.ports.out.processor.SocialMentionProcessorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class SocialMentionProcessorImpl implements SocialMentionProcessorService {

    private final DetermineSourceService determineSourceService;

    private final BuilderMessageService builderMessageService;

    private final AnalyzerSMService analyzerSMService;

    private final CategorizerRiskService categorizerRiskService;

    private final SaverSocialMentionService socialMentionSaver;


    @Override
    public Mono<AnalysisSocialMentionResponseDto> processSocialMention(SocialMentionDto socialMentionDto) {
        return determineSourceService.determineSourceSocialMention(socialMentionDto)
                .flatMap(builderMessageService::buildMessage)
                .flatMap(analyzerSMService::qualifySocialMention)
                .flatMap(categorizerRiskService::categorizeRiskLevelSocialMention)
                .flatMap(socialMentionSaver::saveSocialMention)
                .doOnError(throwable -> log.error(throwable.getMessage()));
    }
}
