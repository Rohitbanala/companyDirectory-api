package com.Company.Company.GlobalExceptionHandler;

public class APIException extends RuntimeException {
    public APIException() {
    }
    public APIException(String message) {
        super(message);
    }
}
