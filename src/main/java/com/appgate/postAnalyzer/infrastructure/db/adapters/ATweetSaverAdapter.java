package com.appgate.postAnalyzer.infrastructure.db.adapters;

import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import com.appgate.postAnalyzer.domain.dto.AnalysisSocialMentionResponseDto;
import com.appgate.postAnalyzer.domain.ports.in.ATweetPersistencePort;
import com.appgate.postAnalyzer.domain.service.tw.MapperTWService;
import com.appgate.postAnalyzer.infrastructure.db.repository.AnalyzedTweetRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
@Slf4j
public class ATweetSaverAdapter implements ATweetPersistencePort {
    private final AnalyzedTweetRepository analyzedTweetRepository;
    @Override
    public Mono<AnalysisSocialMentionResponseDto> insertTWSocialMention(ScoreSMBO scoreSocialMentionBO) {
         return analyzedTweetRepository.save(MapperTWService.fromScoreSMBOToAnalyzedTweet(scoreSocialMentionBO))
                 .map(MapperTWService::fromAnalyzedTweetToAnalysisSocialMentionResponseDto);
    }
}
