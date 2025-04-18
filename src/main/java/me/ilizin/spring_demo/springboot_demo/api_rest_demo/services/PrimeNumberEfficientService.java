package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import org.springframework.stereotype.Service;

@Service
public class PrimeNumberEfficientService implements IPrimeNumberService {
    @Override
    public boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        }
        Boolean[] primes = new Boolean[value];
        primes[0] = false;
        int i = 1;
        primes[1] = true;
        while (i < value) {
            if (primes[i] == null) {
                primes[i] = true;
            }
            int j = 2;
            boolean end = false;
            while (!end) {
                int k = (i + 1) * j;
                if (k == value) {
                    return false;
                } else
                if (k < value) {
                    primes[k - 1] = false;
                    j++;
                } else {
                    end = true;
                }
            }
            i++;
        }
        return primes[value - 1];
    }
}
