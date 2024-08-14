package com.appgate.postAnalyzer.web.controller;

import com.appgate.postAnalyzer.domain.dto.AnalysisSocialMentionResponseDto;
import com.appgate.postAnalyzer.domain.dto.SocialMentionDto;
import com.appgate.postAnalyzer.domain.exceptions.ApiUnprocessableEntity;
import com.appgate.postAnalyzer.domain.ports.out.processor.ValidatorService;
import com.appgate.postAnalyzer.domain.ports.out.processor.SocialMentionProcessorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/analyzer")
@AllArgsConstructor
@Slf4j
public class SocialMentionsController {

    private final ValidatorService validatorService;

    private final SocialMentionProcessorService socialMentionProcessorService;
    @PostMapping("/socialMention")
    public ResponseEntity<Mono<AnalysisSocialMentionResponseDto>> saveAccount(@RequestBody final SocialMentionDto socialMentionDto) throws ApiUnprocessableEntity {
        validatorService.validParams(socialMentionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(socialMentionProcessorService.processSocialMention(socialMentionDto));
    }
}
