package com.appgate.postAnalyzer.domain.service.tw;

import com.appgate.postAnalyzer.domain.bo.SourceSMBO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;
@Service
@RequiredArgsConstructor
public class TWBuildMessage  {

    private static final String PREFIX_MESSAGE = "twitterMessage: %s";


    public static String buildMessage(SourceSMBO sourceSocialMentionBO) {
        return format(PREFIX_MESSAGE, sourceSocialMentionBO.getSocialMentionDto().getMessage());
    }
}
