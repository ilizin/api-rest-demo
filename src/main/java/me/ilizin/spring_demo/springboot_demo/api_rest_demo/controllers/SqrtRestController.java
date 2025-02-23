package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.ISqrtService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SqrtRestController {

    private final ISqrtService sqrtService;

    public SqrtRestController(ISqrtService sqrtService) {
        this.sqrtService = sqrtService;
    }

    @Operation(summary = "Calculate the square roots",
            description = "Calculate a number square roots with the Heron algorithm")
    @GetMapping("/sqrt/{value}")
    public double sqrt(@PathVariable int value) {
        return sqrtService.sqrt(value);
    }
}
