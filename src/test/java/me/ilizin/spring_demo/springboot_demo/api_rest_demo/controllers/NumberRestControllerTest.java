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
public class NumberRestControllerTest {

    private static final String PRIME_URL = "/v1/prime/";
    private static final String SQRT_URL = "/v1/sqrt/";

    private static Stream<Arguments> sqrtArguments() {
        return Stream.of(
                Arguments.of("9", "{\"value\":\"3.0\",\"responseTime\":0}", status().isOk()),
                Arguments.of("4", "{\"value\":\"2.0\",\"responseTime\":0}", status().isOk()),
                Arguments.of("bad_number", null, status().isBadRequest())
        );
    }

    private static Stream<Arguments> primeArguments() {
        return Stream.of(
                Arguments.of("9", "{\"value\":\"false\",\"responseTime\":0}", status().isOk()),
                Arguments.of("4", "{\"value\":\"false\",\"responseTime\":0}", status().isOk()),
                Arguments.of("11", "{\"value\":\"true\",\"responseTime\":0}", status().isOk()),
                Arguments.of("bad_number", null, status().isBadRequest())
        );
    }

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("primeArguments")
    void prime(String value, String expectedResult, ResultMatcher expectedState) throws Exception {
        ResultActions resultActions = this.mockMvc.perform(get(PRIME_URL + value));
        resultActions.andExpect(expectedState);
        if (!value.equals("bad_number")) {
            resultActions.andExpect(content().string(expectedResult));
        }
    }

    @ParameterizedTest
    @MethodSource("sqrtArguments")
    void sqrt(String value, String expectedResult, ResultMatcher expectedState) throws Exception {
        ResultActions resultActions = this.mockMvc.perform(get(SQRT_URL + value));
        resultActions.andExpect(expectedState);
        if (!value.equals("bad_number")) {
            resultActions.andExpect(content().string(expectedResult));
        }
    }
}
