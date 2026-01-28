package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.enums.PrimeMethod;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeNumberBasicServiceTest {

    private static Stream<Arguments> isPrime() {
        return Stream.of(
                Arguments.of(9, false),
                Arguments.of(4, false),
                Arguments.of(11, true),
                Arguments.of(101, true)
        );
    }

    private final PrimeNumberBasicService primeNumberBasicService;

    public PrimeNumberBasicServiceTest() {
        this.primeNumberBasicService = new PrimeNumberBasicService();
    }

    @ParameterizedTest
    @MethodSource("isPrime")
    public void isPrime(int value, boolean expectedResult) {
        assertThat(primeNumberBasicService.isPrime(value, PrimeMethod.NAIVE_METHOD))
                .isEqualTo(expectedResult);
    }
}
