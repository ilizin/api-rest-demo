package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.interfaces.PrimeNumberService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class PrimeNumberEfficientService implements PrimeNumberService {
    @Override
    public boolean isPrime(int value) {
        return false;
    }
}
