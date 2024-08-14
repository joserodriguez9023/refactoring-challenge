package com.appgate.postAnalyzer.domain.bo;

import com.appgate.postAnalyzer.domain.dto.SocialMentionDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode
public class SourceSMBO {
    public SocialMentionDto socialMentionDto;
    public Boolean isFacebook;
}
