package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PrimeNumberRestControllerTest {

    private static final String BASE_URL = "/api/prime/";

    private static Stream<Arguments> primeArguments() {
        return Stream.of(
                Arguments.of("9", "false", status().isOk()),
                Arguments.of("4", "false", status().isOk()),
                Arguments.of("11", "true", status().isOk()),
                Arguments.of("bad_number", null, status().isBadRequest())
        );
    }

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("primeArguments")
    void sqrt(String value, String expectedResult, ResultMatcher expectedState) throws Exception {
        ResultActions resultActions = this.mockMvc.perform(get(BASE_URL + value));
        resultActions.andExpect(expectedState);
        if (!value.equals("bad_number")) {
            resultActions.andExpect(content().string(containsString(expectedResult)));
        }
    }
}
