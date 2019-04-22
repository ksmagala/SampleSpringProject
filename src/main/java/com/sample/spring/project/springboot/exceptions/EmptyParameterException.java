package com.sample.spring.project.springboot.exceptions;

public class EmptyParameterException extends RuntimeException {
    public EmptyParameterException(String message) {
        super(message);
    }
}
