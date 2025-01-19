package com.sideralti.app.exceptions.entity;

public class ErrorResponse {

    private int status;
    private String message;
    private String path;

    public ErrorResponse(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
