package me.ilizin.spring_demo.springboot_demo.api_rest_demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.enums.PrimeMethod;

public class PrimeInDto {
    @Schema(description = "The integer value we want to validate if it's prime", example = "17")
    private int value;
    @Schema(description = "The method used to check if a number is prime", example = "NAIVE_METHOD")
    private PrimeMethod primeMethod;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public PrimeMethod getPrimeMethod() {
        return primeMethod;
    }

    public void setPrimeMethod(PrimeMethod primeMethod) {
        this.primeMethod = primeMethod;
    }
}
