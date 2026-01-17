package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GcdServiceTest {

    private static Stream<Arguments> gcd() {
        return Stream.of(
                Arguments.of(100, 50, 50),
                Arguments.of(50, 100, 50)
        );
    }

    private final GcdService gcdService;

    public GcdServiceTest() {
        this.gcdService = new GcdService();
    }

    @ParameterizedTest
    @MethodSource("gcd")
    public void sqrt(int value1, int value2, int expectedGcd) {
        assertThat(gcdService.gcd(value1, value2)).isEqualTo(expectedGcd);
    }
}
