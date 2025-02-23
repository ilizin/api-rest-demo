package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

public class PalindromeErrorResponse {

    private int status;
    private String message;
    private long timestamp;

    public PalindromeErrorResponse() {}

    public PalindromeErrorResponse(int status, long timestamp, String message) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
