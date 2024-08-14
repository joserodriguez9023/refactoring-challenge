package com.appgate.postAnalyzer.domain.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RiskLevels {
    HIGH_RISK("HIGH_RISK"),
    MEDIUM_RISK("MEDIUM_RISK"),
    LOW_RISK("LOW_RISK");


    public final String level;

}
