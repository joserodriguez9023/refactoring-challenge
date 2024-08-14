package com.appgate.postAnalyzer.infrastructure.db.adapters;

import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import com.appgate.postAnalyzer.domain.dto.AnalysisSocialMentionResponseDto;
import com.appgate.postAnalyzer.domain.ports.in.AFbPostPersistencePort;
import com.appgate.postAnalyzer.domain.service.fb.MapperFBService;
import com.appgate.postAnalyzer.infrastructure.db.repository.AnalyzedFbPostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
@Slf4j
public class AFbPostSaverAdapter  implements AFbPostPersistencePort {
    private final AnalyzedFbPostRepository analyzedFbPostRepository;
    @Override
    public Mono<AnalysisSocialMentionResponseDto> insertFBSocialMention(ScoreSMBO scoreSocialMentionBO) {
        return analyzedFbPostRepository.save(
                MapperFBService.fromScoreSMBOToAnalyzedFbPost(scoreSocialMentionBO))
                        .map(MapperFBService::fromAnalyzedFbPostToAnalysisSocialMentionResponseDto);
    }
}
