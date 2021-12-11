package com.example.endofgame.controller;

import com.example.endofgame.dto.ErrorResponse;
import com.example.endofgame.exception.BusinessException;
import com.example.endofgame.exception.DeletingNonExistentObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;

@RestControllerAdvice
public class BusinessControllerAdvice {

    @ExceptionHandler(DeletingNonExistentObject.class)
    public ResponseEntity<ErrorResponse> handleNonExistentCategoryEntities(BusinessException exc) {
        ErrorResponse response = createGenericErrorResponse(HttpStatus.NOT_FOUND, exc);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateCategoryEntities(BusinessException exc) {
        ErrorResponse response = createGenericErrorResponse(HttpStatus.BAD_REQUEST, exc);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    private ErrorResponse createGenericErrorResponse(HttpStatus status, BusinessException exc){
        return new ErrorResponse(
                LocalDateTime.now(),
                "You're doing it wrong",
                exc.getMessage(),
                status.value(),
                ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath()
        );
    }
}
