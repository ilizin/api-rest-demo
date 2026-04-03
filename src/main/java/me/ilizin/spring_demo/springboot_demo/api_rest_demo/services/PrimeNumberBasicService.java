package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.enums.PrimeMethod;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
/* This is not necessary because the scope is singleton by default.
   The prototype scope creates an object for each injection */
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PrimeNumberBasicService implements IPrimeNumberService {

    @Override
    public String primes(int value, PrimeMethod primeMethod) {
        StringBuilder primes = new StringBuilder();
        if (value <= 1) {
            return primes.toString();
        }
        for (int i = 2; i <= value; i++) {
            if (isPrime(i)) {
                primes.append(i).append(';');
            }
        }
        return primes.toString();
    }

    public boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        }
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
