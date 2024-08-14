package com.appgate.postAnalyzer.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder (toBuilder = true)
public class AnalysisSocialMentionResponseDto {
    private String level;
    private String typeAccount;
    private String nameAccount;
    private double score;
    private String analysisDate;
    private boolean isSaved;
}
