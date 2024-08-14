package com.appgate.postAnalyzer.domain.service.processor;

import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import com.appgate.postAnalyzer.domain.dto.AnalysisSocialMentionResponseDto;
import com.appgate.postAnalyzer.domain.ports.in.AFbPostPersistencePort;
import com.appgate.postAnalyzer.domain.ports.in.ATweetPersistencePort;
import com.appgate.postAnalyzer.domain.service.fb.MapperFBService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class SaverSocialMentionImpl implements SaverSocialMentionService {
    private final AFbPostPersistencePort aFbPostPersistencePort;

    private final ATweetPersistencePort aATweetPersistencePort;

    @Override
    public Mono<AnalysisSocialMentionResponseDto> saveSocialMention(ScoreSMBO scoreSocialMentionBO) {
        if (scoreSocialMentionBO.getToSave() && scoreSocialMentionBO.getIsFacebook() ) {
            return aFbPostPersistencePort.insertFBSocialMention(scoreSocialMentionBO);
        }
        if(!scoreSocialMentionBO.getIsFacebook()) {
            return aATweetPersistencePort.insertTWSocialMention(scoreSocialMentionBO);
        }
      return Mono.just(MapperFBService.fromScoreSMBOToAnalysisSocialMentionResponseDto(scoreSocialMentionBO));

    }



}
