package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.model.GcdInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.model.OkResponseDTO;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.model.PrimeInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.IGcdService;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.IPrimeNumberService;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.ISqrtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
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

    @GetMapping("/sqrt/{value}")
    public OkResponseDTO sqrt(@Parameter(description = "A positive number the square root must be calculated", example = "4")
                       @PathVariable @Positive(message = "The value must be positive")  int value) {
        Instant start = Instant.now();
        String response = String.valueOf(sqrtService.sqrt(value));
        Instant end = Instant.now();
        return new OkResponseDTO(response, end.getEpochSecond() - start.getEpochSecond());
    }

    @GetMapping("/prime")
    public OkResponseDTO isPrime(@Valid PrimeInDto primeInDto) {
        Instant start = Instant.now();
        String response = String.valueOf(primeNumberService.isPrime(primeInDto.getValue(), primeInDto.getMethod()));
        Instant end = Instant.now();
        return new OkResponseDTO(response, end.getEpochSecond() - start.getEpochSecond());
    }

    @GetMapping("/gcd")
    public OkResponseDTO gcd(@Valid GcdInDto gcdInDto) {
        Instant start = Instant.now();
        String response = String.valueOf(gcdService.gcd(gcdInDto.getValue1(), gcdInDto.getValue2()));
        Instant end = Instant.now();
        return new OkResponseDTO(response, end.getEpochSecond() - start.getEpochSecond());
    }
}
