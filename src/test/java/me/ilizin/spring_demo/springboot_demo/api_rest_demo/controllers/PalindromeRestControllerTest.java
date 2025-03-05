package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.ApiRestDemoApplication;
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

/* Another useful approach is to not start the server at all but to test only the layer below that,
   where Spring handles the incoming HTTP request and hands it off to your controller. That way, almost all of the
   full stack is used, and your code will be called in exactly the same way as if it were processing a real
   HTTP request but without the cost of starting the server. To do that, use Spring’s MockMvc and ask for that
   to be injected for you by using the @AutoConfigureMockMvc annotation on the test case. */
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) // addFilters=false disables the spring security //TODO Improve this
public class PalindromeRestControllerTest {

    private static final String BASE_URL = "/api/palindrome/";

    private static Stream<Arguments> isPalindromeArguments() {
        return Stream.of(
                Arguments.of("rotavator", "true", status().isOk()),
                Arguments.of("DylanDog", "false", status().isOk()),
                Arguments.of("1000", null, status().isBadRequest())
        );
    }

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("isPalindromeArguments")
    void isPalindrome(String word, String expectedResult, ResultMatcher expectedState) throws Exception {
        //As we don't start the server, the URLs won't be prefixed with the context-path
        ResultActions resultActions = this.mockMvc.perform(get(BASE_URL + word));
        resultActions.andExpect(expectedState);
        if (!word.equals("1000")) { //TODO Improve this, find a more elegant solution
            resultActions.andExpect(content().string(containsString(expectedResult)));
        }
    }
}