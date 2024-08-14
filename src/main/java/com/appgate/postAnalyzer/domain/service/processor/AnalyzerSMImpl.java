package com.appgate.postAnalyzer.domain.service.processor;

import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import com.appgate.postAnalyzer.domain.bo.SourceSMBO;
import com.appgate.postAnalyzer.domain.service.fb.FBAnalyzerService;
import com.appgate.postAnalyzer.domain.service.tw.TWAnalyzerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class AnalyzerSMImpl implements AnalyzerSMService {
    private final FBAnalyzerService fbAnalyzerService;

    private final TWAnalyzerService twAnalyzerService;


    @Override
    public Mono<ScoreSMBO> qualifySocialMention(SourceSMBO sourceSocialMentionBO) {
        return Mono.just(processSocialMention(sourceSocialMentionBO));
    }


    private ScoreSMBO processSocialMention(SourceSMBO sourceSocialMentionBO) {
        return (sourceSocialMentionBO.getIsFacebook()) ?
                fbAnalyzerService.analyze(sourceSocialMentionBO) :
                twAnalyzerService.analyze(sourceSocialMentionBO);
    }


}
