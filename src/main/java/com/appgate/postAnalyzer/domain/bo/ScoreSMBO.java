package com.appgate.postAnalyzer.domain.bo;

import com.appgate.postAnalyzer.domain.dto.SocialMentionDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode
public class ScoreSMBO {
    public SocialMentionDto socialMentionDto;
    public Boolean isFacebook;
    public double score;
    public Boolean toSave;
    public String level;
}
