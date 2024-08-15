package com.mycompany.property_management.exception;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger=LoggerFactory.getLogger(this.getClass());

//    This method handles exceptions related to validation failures, specifically MethodArgumentNotValidException,
//    which is thrown when a method argument annotated with @Valid fails validation.
//    Process:
//    It extracts the list of field errors (FieldError) from the exception.
//    For each field error, it creates an ErrorModel object containing the field name (code) and the validation error message (message).
//    It then adds these ErrorModel objects to a list.
//     Response: Returns a BAD_REQUEST (400) status with the list of errors in the response body.

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<List<ErrorModel>>  handleFieldValidation(MethodArgumentNotValidException manv) {
//      List<ErrorModel> errorModelList=new ArrayList<>();
//      ErrorModel errorModel=null;
//      List<FieldError> fieldErrorsList=manv.getBindingResult().getFieldErrors();
//
//      for(FieldError fe:fieldErrorsList){
//         // logger.debug("Inside field validation exception handler - Field: {}, Message: {}", fe.getField(), fe.getDefaultMessage());
//      //    logger.info("Inside field validation exception handler - Field: {}, Message: {}", fe.getField(), fe.getDefaultMessage());
//          errorModel=new ErrorModel();
//          errorModel.setCode(fe.getField());
//          errorModel.setMessage(fe.getDefaultMessage());
//          errorModelList.add(errorModel);
//      }
//        return new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex) {

        for(ErrorModel em: bex.getErrorModel()){
            logger.error("Inside Business Exception Handler - Code: {}, Message: {}", em.getCode(), em.getMessage());
        }
        // Simplified generics usage
        return new ResponseEntity<List<ErrorModel>>(bex.getErrorModel(), HttpStatus.BAD_REQUEST);
    }
}
