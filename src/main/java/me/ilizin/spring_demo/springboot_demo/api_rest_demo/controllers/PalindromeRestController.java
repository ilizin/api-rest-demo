package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeRestController {

    @Autowired
    private PalindromeService palindromeService;

    @GetMapping("/palindrome/{value}")
    public boolean isPalindrome(@PathVariable String value) {
        return palindromeService.isPalindrome(value);
    }
}
