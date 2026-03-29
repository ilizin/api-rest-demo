package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.enums.PrimeMethod;

public interface IPrimeNumberService {

    String primes(int value, PrimeMethod primeMethod);
}
