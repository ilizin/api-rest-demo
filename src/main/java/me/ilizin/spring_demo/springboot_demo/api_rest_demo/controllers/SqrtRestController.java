package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.ISqrtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SqrtRestController {

    private final ISqrtService sqrtService;

    public SqrtRestController(ISqrtService sqrtService) {
        this.sqrtService = sqrtService;
    }

    @Operation(summary = "Calculate the square roots",
            description = "Calculate the square roots using the Heron algorithm")
    @GetMapping("/sqrt/{value}")
    public double sqrt(@PathVariable int value) {
        return sqrtService.sqrt(value);
    }
}
