package com.mcq.quizapp.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{

    private final HttpStatus status;

    public CustomException(String message, HttpStatus status){
        super(message);
        this.status= status;
    }
}
