package com.appgate.postAnalyzer.domain.service.fb;

import com.appgate.postAnalyzer.domain.bo.RiskLevels;
import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import reactor.core.publisher.Mono;

public class FBCategorizedRisk {

    public static Mono<ScoreSMBO> selectRiskLevel(ScoreSMBO scoreSMBO){
        scoreSMBO.setLevel(setRiskLevel(scoreSMBO.getScore()));
        return Mono.just(scoreSMBO);

    }

    private static String setRiskLevel(Double level){
        if (level == -100d) {
            return RiskLevels.HIGH_RISK.getLevel();
        } else if (level > -100d && level < 50d) {
            return RiskLevels.MEDIUM_RISK.getLevel();
        }
            return  RiskLevels.LOW_RISK.getLevel();

    }
}
