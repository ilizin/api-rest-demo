package me.ilizin.spring_demo.springboot_demo.api_rest_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.interfaces.SqrtService;

/* Doesn't have the Component annotation, instead we configure it as a Spring bean suing the Bean annotation.
   The Bean annotation is useful when we take an existing third-party class and expose it as a Spring bean. */
public class SqrtEroneService implements SqrtService {

    @Override
    public int sqrt(int value) {
        return -1000;
    }
}
