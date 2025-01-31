package me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.interfaces.EroneService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EroneRestController {

    private final EroneService eroneService;

    public EroneRestController(EroneService eroneService) {
        this.eroneService = eroneService;
    }

}
