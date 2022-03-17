package com.example.demo.responses;

public class ExceptionResponce {

    private String message;

    public ExceptionResponce(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
