package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import org.springframework.stereotype.Service;

@Service
public class GcdService {

    int gcd(int value1, int value2) {
        while (value1 > 0 && value2 > 0)  {
            if (value1 > value2) {
                value1 = value1 % value2;
            } else {
                value2 = value2 % value1;
            }
        }
        return value1 != 0 ? value1 : value2;
    }
}
