package com.appgate.postAnalyzer.domain.service.tw;
import com.appgate.postAnalyzer.domain.bo.RiskLevels;
import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import reactor.core.publisher.Mono;

public class TWCategorizedRisk {


    public static Mono<ScoreSMBO> selectRiskLevel(ScoreSMBO scoreSMBO){
        scoreSMBO.setLevel(setRiskLevel(scoreSMBO.getScore()));
        return Mono.just(scoreSMBO);

    }

    private static String setRiskLevel(Double level){
        if (level >= -1 && level <= -0.5d) {
            return RiskLevels.HIGH_RISK.getLevel();
        } else if (level > -0.5d && level < 0.7d) {
            return  RiskLevels.MEDIUM_RISK.getLevel();
        }
        return RiskLevels.LOW_RISK.getLevel();
    }

}
