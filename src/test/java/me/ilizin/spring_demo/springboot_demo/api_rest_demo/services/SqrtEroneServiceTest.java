package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SqrtEroneServiceTest {

    private static Stream<Arguments> sqrt() {
        return Stream.of(
                Arguments.of(9, 3),
                Arguments.of(4, 2)
        );
    }

    private final SqrtEroneService sqrtEroneService;

    public SqrtEroneServiceTest() {
        this.sqrtEroneService = new SqrtEroneService();
    }

    @ParameterizedTest
    @MethodSource("sqrt")
    public void sqrt(int value, int expectedResult) {
        assertThat(Math.round(sqrtEroneService.sqrt(value)))
                .isEqualTo(expectedResult);
    }
}
