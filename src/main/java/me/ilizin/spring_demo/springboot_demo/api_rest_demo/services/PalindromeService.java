package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PalindromeService {

    @Value("${palindrome.service.recursive}")
    private boolean isRecursive;

    public boolean isPalindrome(String value) {
        if (isRecursive) {
            return isPalindromeRecursive(value);
        } else {
            return isPalindromeIterative(value);
        }
    }

    public boolean isPalindromeIterative(String value) {
        //TODO
        return false;
    }

    public boolean isPalindromeRecursive(String value) {
        int lastCharacterPosition = value.length() - 1;
        if (value.isEmpty() || value.length() == 1) {
            return true;
        } else {
            if (value.charAt(0) != value.charAt(lastCharacterPosition)) {
                return false;
            }
            return isPalindrome(value.substring(1, lastCharacterPosition));
        }
    }
}
