package com.appgate.postAnalyzer.domain.ports.out.processor;

import com.appgate.postAnalyzer.domain.dto.SocialMentionDto;
import com.appgate.postAnalyzer.domain.exceptions.ApiUnprocessableEntity;

public interface ValidatorService {
    void validParams(SocialMentionDto socialMentionDto) throws ApiUnprocessableEntity;
}
