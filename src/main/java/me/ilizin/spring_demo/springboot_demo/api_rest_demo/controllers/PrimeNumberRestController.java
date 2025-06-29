package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.IPrimeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Prime controller")
@RequestMapping("/api")
public class PrimeNumberRestController {

    private IPrimeNumberService primeNumberService;

    //An example of setter injection
    /* We've two PrimeNumberService implementation, but spring knows what to instantiate
       because one of them is marked as Primary */
    //When using both Primary and Qualifier annotations, the Qualifier one has the priority.
    @Autowired
    void setPrimeNumberService(IPrimeNumberService primeNumberService) {
        this.primeNumberService = primeNumberService;
    }

    @Operation(summary = "Check if a number ia prime",
            description = "Check if a number ia prime")
    @GetMapping("/prime/{value}")
    public boolean isPalindrome(@PathVariable int value) {
        return primeNumberService.isPrime(value);
    }
}
