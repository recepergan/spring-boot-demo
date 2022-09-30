package com.example.springboot01.exception;

public class CustomerAlreadyExistsException extends RuntimeException {

    public CustomerAlreadyExistsException(String message) {

        super(message);
    }
}

