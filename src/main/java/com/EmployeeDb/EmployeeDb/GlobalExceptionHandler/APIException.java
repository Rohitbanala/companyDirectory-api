package com.EmployeeDb.EmployeeDb.GlobalExceptionHandler;

public class APIException extends RuntimeException {
    public APIException() {
    }
    public APIException(String message) {
        super(message);
    }
}
