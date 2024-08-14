package com.appgate.postAnalyzer.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


import java.util.List;

@Builder(toBuilder = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SocialMentionDto {
    private String message;
    private String facebookAccount;
    private String twitterAccount;
    private String creationDate;
    private String twitterUrl;
    private List<String> facebookComments;

}
