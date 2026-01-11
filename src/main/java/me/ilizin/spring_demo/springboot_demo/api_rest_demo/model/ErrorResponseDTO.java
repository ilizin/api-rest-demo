package me.ilizin.spring_demo.springboot_demo.api_rest_demo.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class ErrorResponseDTO {

    @Schema(description = "The error status code", example = "400")
    private int status;
    @Schema(description = "The error message", example = "The value must be positive")
    private String message;

    public ErrorResponseDTO() {}

    public ErrorResponseDTO(int status, String message) {
        this.status = status;
        this.message = message;
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
