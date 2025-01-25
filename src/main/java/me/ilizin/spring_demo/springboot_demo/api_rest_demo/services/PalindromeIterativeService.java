package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.interfaces.PalindromeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PalindromeIterativeService implements PalindromeService {
    private static final Logger logger = LoggerFactory.getLogger(PalindromeIterativeService.class);

    public boolean isPalindrome(String value) {
        for (int i = 0; i < value.length() / 2; i++) {
            if (value.charAt(i) != value.charAt(value.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
