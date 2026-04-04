package me.ilizin.spring_demo.springboot_demo.api_rest_demo.utils;

public class ApiRestDemoUtils {

    public static String removeLastSemiColon(String primes) {
        if (primes.endsWith(";")) {
            primes = primes.substring(0, primes.length() - 1);
        }
        return primes;
    }
}
