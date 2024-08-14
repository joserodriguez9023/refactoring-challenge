package com.appgate.postAnalyzer.domain.service.fb;

import com.appgate.postAnalyzer.domain.bo.SourceSMBO;

import static java.lang.String.format;


public class FBBuildMessage {
    private static final String PREFIX_MESSAGE = "facebookMessage: %s";
    private static final String PREFIX_COMMENTS = " || comments: %s";

    public static String buildMessage(SourceSMBO sourceSocialMentionBO) {
         String result = format(PREFIX_MESSAGE, sourceSocialMentionBO.getSocialMentionDto().getMessage());
       if(!sourceSocialMentionBO.getSocialMentionDto().getFacebookComments().isEmpty()){
            result = result.concat(format(PREFIX_COMMENTS, sourceSocialMentionBO
                                                            .getSocialMentionDto()
                                                            .getFacebookComments()
                                                            .stream()
                                                            .reduce("", (h, c) -> h + " " + c)));
       }
        return result;
    }


}

