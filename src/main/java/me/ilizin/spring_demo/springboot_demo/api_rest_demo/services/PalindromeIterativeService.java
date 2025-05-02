package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/* The Lazy Initialization postpones the creation of the object until it is first requested. This is useful when
  the object creation is resource-intensive or when the object is not immediately required during the application startup.
  By default, Spring initializes all singleton beans eagerly at the application startup. */
@Lazy
/* The Service annotation is used to indicate that a class belongs to the service layer in an application.
   The service layer typically contains the business logic of the application. The @Service annotation is a specialization
   of the Component annotation, meaning that classes annotated with Service are automatically detected during classpath scanning.*/
@Service
public class PalindromeIterativeService implements IPalindromeService {
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
