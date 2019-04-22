package com.sample.spring.project.springboot.exceptions;

public class CarDoesNotExistException extends RuntimeException {
    public CarDoesNotExistException(String message) {
        super(message);
    }
}
