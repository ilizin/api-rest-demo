package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.interfaces.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeRestController {

    @Value("${palindrome.service.recursive}")
    private boolean isRecursive;

    // Private field for dependency
    private final PalindromeService palindromeService;

    // Constructor for dependency injection
    // The autowired annotation is optional because we've only one constructor
    // The Qualifier annotation is necessary because we've more than one PalindromeService implementation
    @Autowired
    public PalindromeRestController(@Qualifier("palindromeRecursiveService") PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    @GetMapping("/palindrome/{value}")
    public boolean isPalindrome(@PathVariable String value) {
        return palindromeService.isPalindrome(value);
    }
}
