package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.model.ErrorResponseDTO;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.model.GcdInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.model.OkResponseDTO;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.model.PrimeInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.IGcdService;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.IPrimeNumberService;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.ISqrtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.time.Instant;

@RestController
@Tag(name = "Number controller")
@RequestMapping("/v1")
public class NumberRestController {

    private final ISqrtService sqrtService;
    private IPrimeNumberService primeNumberService;
    @Autowired
    private IGcdService gcdService;

    public NumberRestController(ISqrtService sqrtService) {
        this.sqrtService = sqrtService;
    }

    //An example of setter injection
    /* We've two PrimeNumberService implementation, but spring knows what to instantiate
       because one of them is marked as Primary */
    //When using both Primary and Qualifier annotations, the Qualifier one has the priority.
    @Autowired
    void setPrimeNumberService(IPrimeNumberService primeNumberService) {
        this.primeNumberService = primeNumberService;
    }

    @Operation(summary = "Calculate the square roots of a positive number",
               description = "Calculate the square roots of a positive number using the Heron algorithm")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful square roots calculation",
                    content = { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = OkResponseDTO.class),
                            examples = { @ExampleObject(value = "{\"value\": 2, \"responseTime\":10}")})}),
            @ApiResponse(responseCode = "400", description = "Incorrect input value",
                         content = { @Content(mediaType = "application/json", schema =
                                     @Schema(implementation = ErrorResponseDTO.class)) })
    })
    @GetMapping("/sqrt/{value}")
    public OkResponseDTO sqrt(@Parameter(description = "A positive number the square root must be calculated", example = "4")
                       @PathVariable @Positive(message = "The value must be positive")  int value) {
        Instant start = Instant.now();
        String response = String.valueOf(sqrtService.sqrt(value));
        Instant end = Instant.now();
        return new OkResponseDTO(response, end.getEpochSecond() - start.getEpochSecond());
    }

    @Operation(summary = "Check if a number is a prime number",
            description = "Return true if the number is prime else return false")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful prime number evaluation",
                    content = { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = OkResponseDTO.class),
                            examples = { @ExampleObject(value = "{\"value\": true, \"responseTime\":10}")})}),
    })
    @GetMapping("/prime")
    public OkResponseDTO isPrime(@Valid PrimeInDto primeInDto) {
        Instant start = Instant.now();
        String response = String.valueOf(primeNumberService.isPrime(primeInDto.getValue(), primeInDto.getMethod()));
        Instant end = Instant.now();
        return new OkResponseDTO(response, end.getEpochSecond() - start.getEpochSecond());
    }

    @Operation(summary = "Find the Greatest Common Divisor (GCD) of two integers",
            description = "Use the Euclidean Algorithm to find the Greatest Common Divisor (GCD) of two integers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful GCD evaluation",
                    content = { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = OkResponseDTO.class),
                            examples = { @ExampleObject(value = "{\"value\": 35, \"responseTime\":10}")})}),
    })
    @GetMapping("/gcd")
    public OkResponseDTO gcd(@Valid GcdInDto gcdInDto) {
        Instant start = Instant.now();
        String response = String.valueOf(gcdService.gcd(gcdInDto.getValue1(), gcdInDto.getValue2()));
        Instant end = Instant.now();
        return new OkResponseDTO(response, end.getEpochSecond() - start.getEpochSecond());
    }
}
