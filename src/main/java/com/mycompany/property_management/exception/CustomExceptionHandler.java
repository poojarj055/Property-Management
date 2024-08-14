package com.mycompany.property_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex) {

        System.out.println("Business Exception Occurred");
        // Simplified generics usage
        return new ResponseEntity<List<ErrorModel>>(bex.getErrorModel(), HttpStatus.BAD_REQUEST);
    }
}
