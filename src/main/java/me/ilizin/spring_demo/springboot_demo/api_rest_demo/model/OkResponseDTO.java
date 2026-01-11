package me.ilizin.spring_demo.springboot_demo.api_rest_demo.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class OkResponseDTO {

    @Schema(description = "The calculated value", example = "4")
    private String value;
    @Schema(description = "The time in seconds to calculate the value", example = "50")
    private Long responseTime;

    public OkResponseDTO() {}

    public OkResponseDTO(String value, Long responseTime) {
        this.value = value;
        this.responseTime = responseTime;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }
}
