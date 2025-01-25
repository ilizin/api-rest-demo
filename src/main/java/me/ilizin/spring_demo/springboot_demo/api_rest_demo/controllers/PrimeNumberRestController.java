package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.PrimeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeNumberRestController {

    private PrimeNumberService primeNumberService;

    //An example of setter injection
    @Autowired
    void setPrimeNumberService(PrimeNumberService primeNumberService) {
        this.primeNumberService = primeNumberService;
    }

    @GetMapping("/prime/{value}")
    public boolean isPalindrome(@PathVariable int value) {
        return primeNumberService.isPrime(value);
    }

}
