package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.PalindromeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeRestController {

    @Value("${palindrome.service.recursive}")
    private boolean isRecursive;

    @Autowired
    private PalindromeService palindromeService;

    @GetMapping("/palindrome/{value}")
    public boolean isPalindrome(@PathVariable String value) {
        return palindromeService.isPalindrome(value, isRecursive);
    }
}
