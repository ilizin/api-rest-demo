package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.interfaces.PalindromeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
public class PalindromeIterativeService implements PalindromeService {
    private static final Logger logger = LoggerFactory.getLogger(PalindromeIterativeService.class);

    public PalindromeIterativeService() {
        /* You won't see this log because the class is decorated with the Lazy annotation, and
           we're injecting the PalindromeRecursiveService into the PalindromeRestController */
        logger.debug("We're instantiating the palindrome iterative service. ");
    }

    public boolean isPalindrome(String value) {
        for (int i = 0; i < value.length() / 2; i++) {
            if (value.charAt(i) != value.charAt(value.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
