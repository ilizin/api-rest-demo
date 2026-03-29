package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.enums.PrimeMethod;
import org.springframework.stereotype.Service;

@Service
public class PrimeNumberEfficientService extends PrimeNumberBasicService {

    @Override
    public String primes(int value, PrimeMethod primeMethod) {

        if (PrimeMethod.NAIVE_METHOD == primeMethod) {
            return super.primes(value, primeMethod);
        }

        if (PrimeMethod.SIEVE_OF_ERATOSTHENES_METHOD == primeMethod) {
            return isPrimeWithSieveOfEratosthenes(value);
        }

        if (PrimeMethod.SIEVE_OF_SUNDARAM_METHOD == primeMethod) {
            return isPrimeWithSieveOfSundaram(value);
        }

        if (PrimeMethod.SIEVE_OF_ATKIN_METHOD == primeMethod) {
            return isPrimeWithSieveOfEratosthenes(value);
        }

        throw new IllegalArgumentException();
    }

    private String isPrimeWithSieveOfEratosthenes(int value) {
        StringBuilder primes = new StringBuilder();
        if (value <= 1) {
            return primes.toString();
        }
        int[] oneToValueInterval = new int[value + 1];
        for (int i = 2; i < oneToValueInterval.length ; i++) {
            /* We stop when we reach the square root of value
               because any composite (non-prime) number less than or equal to
               value must have at least one prime factor less than or equal to sqrt(value) */
            if (oneToValueInterval[i] == 0 && i > Math.sqrt(value)) {
                for (int a: oneToValueInterval) {
                    if (a == 1) {
                        primes.append(a).append(';');
                    }
                }
                return primes.toString();
            }
            if (oneToValueInterval[i] == 0) { // i + 1 is a prime number
                int j = 2;
                //Mark with one all the 'i' composite numbers
                while (i * j <= value) {
                    oneToValueInterval[i * j] = 1;
                    j++;
                }
            }
        }
        return primes.toString();
    }

    private String isPrimeWithSieveOfSundaram(int value) {
        StringBuilder primes = new StringBuilder();
        if (value <= 1) {
            return primes.toString();
        }

        // List integers 1 to N
        int[] oneToValueInterval = new int[value];

        // Remove the numbers of the form i + j + (2 * i * j) where 1 <= i <= j and i + j + (2 * i * j) <= value
        for (int i = 1; i < value; i++) {
            boolean limit = false;
            for (int j = i; j <= value && !limit; j++) {
                int a = i + j  + (2 * i * j);
                if (a <= value) {
                    oneToValueInterval[a - 1] = 1;
                } else {
                    limit = true;
                }
            }
        }

        // Double the remaining numbers and add 1 
        for (int i = 0; i <= value; i++) {
            if (oneToValueInterval[i] == 0) {
                oneToValueInterval[i] = (i + 1) * 2 + 1;
                if (oneToValueInterval[i] == value) {
                    if (oneToValueInterval[i] == 0 && i > Math.sqrt(value)) {
                        for (int a: oneToValueInterval) {
                            if (a == 1) {
                                primes.append(a).append(';');
                            }
                        }
                        return primes.toString();
                    }
                }
            }
        }
        return primes.toString();
    }

    private String isPrimeWithSieveOfAtkin(int value) {
        // List integers 1 to N
        return null;
    }
}
