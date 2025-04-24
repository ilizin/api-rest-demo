package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.IPalindromeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

/* HTTP requests are handled by a @Controller.
   A convenience annotation that is itself annotated with @Controller and @ResponseBody. */
@RestController
/* You can use the @RequestMapping annotation to map requests to controllers methods. It has various attributes to match by URL,
   HTTP method, request parameters, headers, and media types. You can use it at the class level to express shared mappings or at the method level
   to narrow down to a specific endpoint mapping */
@RequestMapping("/api")
public class PalindromeRestController {
    private static final Logger logger = LoggerFactory.getLogger(PalindromeRestController.class);

    // Another dependency injection example
    @Value("${not.useful.property}")
    private String notUsefulProperty;

    // Private field for dependency
    private final IPalindromeService palindromeService;

    // Constructor for dependency injection
    // The autowired annotation is optional because we've only one constructor
    // The Qualifier annotation is necessary because we've more than one PalindromeService implementation
    @Autowired
    public PalindromeRestController(@Qualifier("palindromeRecursiveService") IPalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    /* handleException --> the exception handler method
    *  ErrorResponse --> type of the response body
    *  InvalidArgumentException --> exception type to handle/catch */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(InvalidArgumentException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(Instant.now().toEpochMilli());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Spring boot uses jackson for (Json, Java pojo) mapping
    @Operation(summary = "Check if a string is palindrome or not",
            description = "Return true if the string is palindrome, else false")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful string evaluation"),
            @ApiResponse(responseCode = "400", description = "Bad request - Invalid string provided"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/palindrome/{value}")
    public boolean isPalindrome(@PathVariable String value) {
        logger.debug("The not.useful.property value is '{}'", notUsefulProperty);
        for(int i = 0; i < value.length(); i++) {
            if (!Character.isLetter(value.charAt(i))) {
                String message = "Wrong '" + value + "' argument, please only use letters";
                throw new InvalidArgumentException(message);
            }
        }
        return palindromeService.isPalindrome(value);
    }
}
