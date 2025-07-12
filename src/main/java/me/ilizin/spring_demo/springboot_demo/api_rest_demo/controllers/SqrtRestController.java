package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.ISqrtService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@Tag(name = "Sqrt controller")
@RequestMapping("/v1")
public class SqrtRestController {

    private final ISqrtService sqrtService;

    public SqrtRestController(ISqrtService sqrtService) {
        this.sqrtService = sqrtService;
    }

    @Operation(summary = "Calculate the square roots of a positive number",
               description = "Calculate the square roots of a positive number using the Heron algorithm")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully calculation",
                         content = { @Content(mediaType = "application/json", schema =
                                     @Schema(example = "2", implementation = Double.class)) }),
            @ApiResponse(responseCode = "400", description = "Incorrect input value",
                         content = { @Content(mediaType = "application/json", schema =
                                     @Schema(implementation = ErrorResponse.class)) })
    })
    @GetMapping("/sqrt/{value}")
    public double sqrt(@Parameter(description = "A positive number the square root must be calculated", example = "4")
                       @PathVariable @Positive(message = "The value must be positive")  int value) {
        return sqrtService.sqrt(value);
    }
}
