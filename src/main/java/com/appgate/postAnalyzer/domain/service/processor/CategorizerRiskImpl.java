package com.appgate.postAnalyzer.domain.service.processor;

import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import com.appgate.postAnalyzer.domain.service.fb.FBCategorizedRisk;
import com.appgate.postAnalyzer.domain.service.tw.TWCategorizedRisk;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CategorizerRiskImpl implements CategorizerRiskService {
    @Override
    public Mono<ScoreSMBO> categorizeRiskLevelSocialMention(ScoreSMBO scoreSMBO) {
        return  (scoreSMBO.isFacebook) ?
                FBCategorizedRisk.selectRiskLevel(scoreSMBO):
                TWCategorizedRisk.selectRiskLevel(scoreSMBO);
    }
}
