package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.enums.PrimeMethod;

public interface IPrimeNumberService {

    boolean isPrime(int value, PrimeMethod primeMethod);
}
