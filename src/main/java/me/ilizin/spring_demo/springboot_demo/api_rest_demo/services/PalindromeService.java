package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers.PalindromeRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PalindromeService {
    private static final Logger logger = LoggerFactory.getLogger(PalindromeService.class);

    public boolean isPalindrome(String value, boolean isRecursive) {

        logger.debug("We're running the {} algorithm", isRecursive ? "recursive" : "iterative");
        if (isRecursive) {
            return isPalindromeRecursive(value);
        } else {
            return isPalindromeIterative(value);
        }
    }

    public boolean isPalindromeIterative(String value) {
        for (int i = 0; i < value.length() / 2; i++) {
            if (value.charAt(i) != value.charAt(value.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeRecursive(String value) {
        int lastCharacterPosition = value.length() - 1;
        if (value.isEmpty() || value.length() == 1) {
            return true;
        } else {
            if (value.charAt(0) != value.charAt(lastCharacterPosition)) {
                return false;
            }
            return isPalindromeRecursive(value.substring(1, lastCharacterPosition));
        }
    }
}
