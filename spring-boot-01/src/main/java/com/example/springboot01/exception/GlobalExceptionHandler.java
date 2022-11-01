package com.example.springboot01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

//Exceptionları yakalamamı sağlar.Request responselarda araya girerek.
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({CustomerNotExistsException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleException(CustomerNotExistsException exc) {

        return new ResponseEntity<>(prepareErrorResponse(HttpStatus.NOT_FOUND,exc.getMessage() ),HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler({CustomerAlreadyExistsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleException(CustomerAlreadyExistsException exc) {

        return new ResponseEntity<>(prepareErrorResponse(HttpStatus.NOT_FOUND,exc.getMessage() ),HttpStatus.NOT_FOUND);

    }
    private ErrorResponse prepareErrorResponse(HttpStatus httpStatus,String message) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(message);
        errorResponse.setExceptiontime(LocalDateTime.now());
        return errorResponse;
    }

}
