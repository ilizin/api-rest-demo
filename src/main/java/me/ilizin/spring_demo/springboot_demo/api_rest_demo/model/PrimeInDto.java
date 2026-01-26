package me.ilizin.spring_demo.springboot_demo.api_rest_demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.enums.PrimeMethod;

public class PrimeInDto {
    @Schema(description = "ç", example = "17")
    private int value;
    @Schema(description = "", example = "SIEVE_OF_ERATOSTHENES")
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
