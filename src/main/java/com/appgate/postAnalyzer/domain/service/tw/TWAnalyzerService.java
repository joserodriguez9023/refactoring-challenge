package com.appgate.postAnalyzer.domain.service.tw;

import com.appgate.postAnalyzer.domain.bo.ScoreSMBO;
import com.appgate.postAnalyzer.domain.bo.SourceSMBO;

public interface TWAnalyzerService {
    ScoreSMBO analyze(SourceSMBO sourceSocialMentionBO);
}
