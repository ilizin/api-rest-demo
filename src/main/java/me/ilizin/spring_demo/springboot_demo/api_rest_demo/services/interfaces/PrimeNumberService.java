package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.interfaces;

import org.springframework.stereotype.Service;

@Service
public interface PrimeNumberService {

    boolean isPrime(int value);
}
