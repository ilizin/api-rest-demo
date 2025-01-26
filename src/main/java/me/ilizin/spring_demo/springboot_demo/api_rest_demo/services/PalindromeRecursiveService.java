package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.interfaces.PalindromeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PalindromeRecursiveService implements PalindromeService {
    private static final Logger logger = LoggerFactory.getLogger(PalindromeRecursiveService.class);

    public PalindromeRecursiveService() {
        logger.debug("We're instantiating the palindrome recursive service. ");
    }

    public boolean isPalindrome(String value) {
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
