package me.ilizin.spring_demo.springboot_demo.api_rest_demo.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class GcdInDto {

    @Schema(description = "First number", example = "105")
    private int value1;
    @Schema(description = "Second number", example = "70")
    private int value2;

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }
}
