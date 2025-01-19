package com.sideralti.app.exceptions.validations;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class ValidationErrorResponse {
    private int status;
    private String message;
    private Map<String, String> errors;
    private LocalDateTime timestamp;

    public ValidationErrorResponse(int status, String message, Map<String, String> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }
}