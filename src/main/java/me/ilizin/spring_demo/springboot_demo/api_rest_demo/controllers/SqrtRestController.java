package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.ISqrtService;
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

    @Operation(summary = "Calculate the square roots",
            description = "Calculate the square roots using the Heron algorithm")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully calculation"),
            @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
    })
    @GetMapping("/sqrt/{value}")
    public double sqrt(@PathVariable int value) {
        return sqrtService.sqrt(value);
    }
}
