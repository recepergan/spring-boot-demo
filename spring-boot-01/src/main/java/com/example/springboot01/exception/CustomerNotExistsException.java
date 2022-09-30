package com.example.springboot01.exception;

public class CustomerNotExistsException extends RuntimeException{
    public CustomerNotExistsException(String message) {

        super(message);
    }

}
