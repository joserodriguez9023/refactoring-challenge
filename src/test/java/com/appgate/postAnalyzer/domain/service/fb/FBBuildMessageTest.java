package com.appgate.postAnalyzer.domain.service.fb;

import com.appgate.postAnalyzer.domain.bo.SourceSMBO;
import com.appgate.postAnalyzer.domain.dto.SocialMentionDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FBBuildMessageTest {
    @Test
    public void testBuildMessage_withComments() {
        // Arrange
        SocialMentionDto socialMentionDto = mock(SocialMentionDto.class);
        when(socialMentionDto.getMessage()).thenReturn("This is a message");
        when(socialMentionDto.getFacebookComments()).thenReturn(Arrays.asList("Comment 1", "Comment 2"));

        SourceSMBO sourceSMBO = mock(SourceSMBO.class);
        when(sourceSMBO.getSocialMentionDto()).thenReturn(socialMentionDto);

        // Act
        String result = FBBuildMessage.buildMessage(sourceSMBO);
        // Assert
        assertEquals("facebookMessage: This is a message || comments: Comment 1 Comment 2", result);
    }

    @Test
    public void testBuildMessage_noComments() {
        // Arrange
        SocialMentionDto socialMentionDto = mock(SocialMentionDto.class);
        when(socialMentionDto.getMessage()).thenReturn("This is a message");
        when(socialMentionDto.getFacebookComments()).thenReturn(Collections.emptyList());

        SourceSMBO sourceSMBO = mock(SourceSMBO.class);
        when(sourceSMBO.getSocialMentionDto()).thenReturn(socialMentionDto);

        // Act
        String result = FBBuildMessage.buildMessage(sourceSMBO);

        // Assert
        assertEquals("facebookMessage: This is a message", result);
    }
}