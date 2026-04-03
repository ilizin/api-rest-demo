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
                Arguments.of(9, "2;3;5;7"),
                Arguments.of(4, "2;3"),
                Arguments.of(11, "2;3;5;7;11"),
                Arguments.of(1, ""),
                Arguments.of(5, "2;3;5"),
                Arguments.of(21, "2;3;5;7;11;13;17;19"),
                Arguments.of(23, "2;3;5;7;11;13;17;19;23"),
                Arguments.of(10, "2;3;5;7"),
                Arguments.of(33, "2;3;5;7;11;13;17;19;23;29;31"),
                Arguments.of(101, "2;3;5;7;11;13;17;19;23;29;31;37;41;43;47;53;59;61;67;71;73;79;83;89;97;101")
        );
    }

    private final PrimeNumberEfficientService primeNumberEfficientService;

    public PrimeNumberEfficientServiceTest() {
        this.primeNumberEfficientService = new PrimeNumberEfficientService();
    }

    @ParameterizedTest
    @MethodSource("isPrime")
    public void isPrime(int value, String expectedResult) {
        assertThat(primeNumberEfficientService.primes(value, PrimeMethod.NAIVE_METHOD))
                .isEqualTo(expectedResult);
        assertThat(primeNumberEfficientService.primes(value, PrimeMethod.SIEVE_OF_ERATOSTHENES_METHOD))
                .isEqualTo(expectedResult);
        assertThat(primeNumberEfficientService.primes(value, PrimeMethod.SIEVE_OF_SUNDARAM_METHOD))
                .isEqualTo(expectedResult);
    }
}
