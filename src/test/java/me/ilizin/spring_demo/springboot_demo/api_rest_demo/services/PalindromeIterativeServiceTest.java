package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromeIterativeServiceTest {

    private static Stream<Arguments> isPalindrome() {
        return Stream.of(
                Arguments.of("ana", true),
                Arguments.of("maria", false)
        );
    }

    private final PalindromeIterativeService palindromeService;

    public PalindromeIterativeServiceTest() {
        this.palindromeService = new PalindromeIterativeService();
    }

    @ParameterizedTest
    @MethodSource("isPalindrome")
    public void isPalindrome(String word, boolean expectedResult) {
        assertThat(palindromeService.isPalindrome(word))
                .isEqualTo(expectedResult);
    }
}