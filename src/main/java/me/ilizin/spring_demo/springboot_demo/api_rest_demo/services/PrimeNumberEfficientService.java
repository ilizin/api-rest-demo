package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.enums.PrimeMethod;
import org.springframework.stereotype.Service;

@Service
public class PrimeNumberEfficientService extends PrimeNumberBasicService {

    @Override
    public boolean isPrime(int value, PrimeMethod primeMethod) {

        if (PrimeMethod.NAIVE_METHOD == primeMethod) {
            return super.isPrime(value, primeMethod);
        }

        if (PrimeMethod.SIEVE_OF_ERATOSTHENES_METHOD == primeMethod) {
            return isPrimeWithSieveOfEratosthenes(value);
        }

        if (PrimeMethod.SIEVE_OF_SUNDARAM_METHOD == primeMethod) {
            return isPrimeWithSieveOfEratosthenes(value);
        }

        if (PrimeMethod.SIEVE_OF_ATKIN_METHOD == primeMethod) {
            return isPrimeWithSieveOfEratosthenes(value);
        }

        throw new IllegalArgumentException();
    }

    private boolean isPrimeWithSieveOfEratosthenes(int value) {
        return false;
    }
}
