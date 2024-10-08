package com.appgate.postAnalyzer.domain.service.processor;

import com.appgate.postAnalyzer.domain.dto.SocialMentionDto;
import com.appgate.postAnalyzer.domain.exceptions.ApiUnprocessableEntity;
import com.appgate.postAnalyzer.domain.ports.out.processor.ValidatorService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class ValidatorServiceImpl  implements ValidatorService {

    private static final String SOURCE_MESSAGE = "Error, Twitter or Facebook account must be present";
    private static final String COMMENTS_MESSAGE = "Send the list of comments, even if it's empty.";


    private void message(String message) throws ApiUnprocessableEntity {
        throw new ApiUnprocessableEntity(message);
    }


    @Override
    public void validParams(SocialMentionDto socialMentionDto) throws ApiUnprocessableEntity {
        hasSource(socialMentionDto);
        hasComments(socialMentionDto);
    }

    private void hasSource(SocialMentionDto socialMentionDto) throws ApiUnprocessableEntity{

        if(socialMentionDto.getFacebookAccount() == null || socialMentionDto.getFacebookAccount().trim().isEmpty())
            if(socialMentionDto.getTwitterAccount() == null || socialMentionDto.getTwitterAccount().trim().isEmpty()){
                    this.message(SOURCE_MESSAGE);
        }
    }

    private void hasComments(SocialMentionDto socialMentionDto) throws ApiUnprocessableEntity {
        if(socialMentionDto.getFacebookAccount() != null && !socialMentionDto.getFacebookAccount().trim().isEmpty()){
            if(socialMentionDto.getFacebookComments()==null){
                this.message(COMMENTS_MESSAGE);
            }
        }


    }

}
