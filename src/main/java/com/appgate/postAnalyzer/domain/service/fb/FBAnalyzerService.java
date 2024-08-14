package com.appgate.postAnalyzer.domain.service.fb;

import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import com.appgate.postAnalyzer.domain.bo.SourceSMBO;

public interface FBAnalyzerService {
    ScoreSMBO analyze(SourceSMBO sourceSocialMentionBO);
}
