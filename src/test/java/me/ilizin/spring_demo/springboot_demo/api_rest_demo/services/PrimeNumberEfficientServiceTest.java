package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.enums.PrimeMethod;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeNumberEfficientServiceTest {
    private static Stream<Arguments> isPrime() {
        return Stream.of(
                Arguments.of(9, false),
                Arguments.of(4, false),
                Arguments.of(11, true),
                Arguments.of(1, false),
                Arguments.of(5, true),
                Arguments.of(21, false),
                Arguments.of(23, true),
                Arguments.of(10, false),
                Arguments.of(33, false),
                Arguments.of(101, true)
        );
    }

    private final PrimeNumberEfficientService primeNumberEfficientService;

    public PrimeNumberEfficientServiceTest() {
        this.primeNumberEfficientService = new PrimeNumberEfficientService();
    }

    @ParameterizedTest
    @MethodSource("isPrime")
    public void isPrime(int value, boolean expectedResult) {
        assertThat(primeNumberEfficientService.isPrime(value, PrimeMethod.NAIVE_METHOD))
                .isEqualTo(expectedResult);
    }
}
