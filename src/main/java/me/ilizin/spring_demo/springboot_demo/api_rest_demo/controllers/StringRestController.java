package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.model.ErrorResponseDTO;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.model.OkResponseDTO;
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
@Tag(name = "String controller")
@RequestMapping("/v1")
public class StringRestController {
    private static final Logger logger = LoggerFactory.getLogger(StringRestController.class);

    // @Value is typically used to inject externalized properties
    // Another dependency injection example
    @Value("${not.useful.property}")
    private String notUsefulProperty;

    // Private field for dependency
    private final IPalindromeService palindromeService;

    // Constructor for dependency injection
    // The autowired annotation is optional because we've only one constructor
    // We've more IPalindromeService implementations, so Spring doesn’t know which bean to inject. To avoid this problem, there are several solutions;
    // the @Qualifier annotation is one of them.
    @Autowired
    public StringRestController(@Qualifier("palindromeRecursiveService") IPalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    /* handleException --> the exception handler method
    *  ErrorResponse --> type of the response body
    *  InvalidArgumentException --> exception type to handle/catch */
    @ExceptionHandler
    public ResponseEntity<ErrorResponseDTO> handleException(InvalidArgumentException exception) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "Check if a string is palindrome or not",
               description = "Return true if the string is palindrome, else false")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful string evaluation",
                    content = { @Content(mediaType = "application/json", schema =
                                @Schema(implementation = OkResponseDTO.class),
                                        examples = { @ExampleObject(value = "{\"value\": true, \"responseTime\":10}")})}),
            @ApiResponse(responseCode = "400", description = "Incorrect input value",
                    content = { @Content(mediaType = "application/json", schema =
                                @Schema(implementation = ErrorResponseDTO.class),
                                        examples = { @ExampleObject(value = "{\"status\": 400, \"message\":\"Wrong '1981' argument, please only use letters\"}")})
             })
    })
    // GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
    @GetMapping("/palindrome/{value}")
    // Spring boot uses jackson for (Json, Java pojo) mapping
    // The PathVariable annotation indicates that a method parameter should be bound to a URI template variable.
    public OkResponseDTO isPalindrome(@Parameter(description = "A word to be checked if it's palindrome or not", example = "Level")
                                @NotBlank @PathVariable String value) {
        Instant start = Instant.now();
        logger.debug("The not.useful.property value is '{}'", notUsefulProperty);
        for(int i = 0; i < value.length(); i++) {
            if (!Character.isLetter(value.charAt(i))) {
                String message = "Wrong '" + value + "' argument, please only use letters";
                throw new InvalidArgumentException(message);
            }
        }
        Instant end = Instant.now();
        String response = String.valueOf(palindromeService.isPalindrome(value));
        return new OkResponseDTO(response, end.getEpochSecond() - start.getEpochSecond());
    }
}