package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.interfaces.SqrtService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqrtRestController {

    private final SqrtService sqrtService;

    public SqrtRestController(SqrtService sqrtService) {
        this.sqrtService = sqrtService;
    }

    @GetMapping("/sqrt/{value}")
    public double sqrt(@PathVariable int value) {
        return sqrtService.sqrt(value);
    }
}
