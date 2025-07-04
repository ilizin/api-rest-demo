package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.ISqrtService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@Tag(name = "Sqrt controller")
@RequestMapping("/api")
public class SqrtRestController {

    private final ISqrtService sqrtService;

    public SqrtRestController(ISqrtService sqrtService) {
        this.sqrtService = sqrtService;
    }

    @Operation(summary = "Calculate the square roots of a positive number",
            description = "Calculate the square roots of a positive number using the Heron algorithm")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully calculation")
    })
    @GetMapping("/sqrt/{value}")
    public double sqrt(@Parameter(description = "A positive number you want to calculate the square root", example = "4")
                           @Validated @Positive @PathVariable int value) {
        return sqrtService.sqrt(value);
    }
}
