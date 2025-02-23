package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PalindromeRecursiveService implements IPalindromeService {
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

    // Add custom code during the bean initialization
    @PostConstruct
    public void doStartupStuffStuff() {
        logger.debug("Doing some startup stuff");
    }

    // Add custom code during the bean destruction
    @PreDestroy
    public void doCleanupStuff() {
        logger.debug("Doing some cleanup stuff");
    }
}
