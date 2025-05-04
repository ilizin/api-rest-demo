package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/* Indicates that a bean should be given preference when multiple candidates are qualified to autowire
   a single-valued dependency. If exactly one 'primary' bean exists among the candidates, it will be the autowired value. */
@Primary
@Service
/* This is not necessary because the scope is singleton by default.
  The prototype scope creates an object for each injection */
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PrimeNumberBasicService implements IPrimeNumberService {
    @Override
    public boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        }
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
