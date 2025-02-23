package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
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

@RestController
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
    *  PalindromeErrorResponse --> type of the response body
    *  InvalidArgumentException --> exception type to handle/catch */
    @ExceptionHandler
    public ResponseEntity<PalindromeErrorResponse> handleException(InvalidArgumentException exception) {
        PalindromeErrorResponse palindromeErrorResponse = new PalindromeErrorResponse();
        palindromeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        palindromeErrorResponse.setMessage(exception.getMessage());
        palindromeErrorResponse.setTimestamp(Instant.now().toEpochMilli());
        return new ResponseEntity<>(palindromeErrorResponse, HttpStatus.BAD_REQUEST);
    }

    // Spring boot uses jackson for (Json, Java pojo) mapping
    @Operation(summary = "Check if a string is palindrome or not",
            description = "Return true if the string is palindrome, else false")
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
