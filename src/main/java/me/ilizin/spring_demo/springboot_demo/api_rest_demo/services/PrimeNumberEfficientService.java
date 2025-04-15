package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import org.springframework.stereotype.Service;

@Service
public class PrimeNumberEfficientService implements IPrimeNumberService {
    @Override
    public boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        }
        boolean[] primes = new boolean[value + 1];
        primes[2] = true;
        int i = 2;
        while (i <= value) {

        }
        return false;
    }
}
