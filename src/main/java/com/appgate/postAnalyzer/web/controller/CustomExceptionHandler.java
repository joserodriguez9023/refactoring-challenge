package com.appgate.postAnalyzer.web.controller;

import com.appgate.postAnalyzer.domain.dto.CustomErrorResponse;
import com.appgate.postAnalyzer.domain.exceptions.ApiUnprocessableEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(ApiUnprocessableEntity.class)
    public ResponseEntity<CustomErrorResponse> handleCustomUnprocessableEntityException(ApiUnprocessableEntity ex) {
        return new ResponseEntity<>(new CustomErrorResponse()
                .toBuilder()
                .message(ex.getMessage())
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .build(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
