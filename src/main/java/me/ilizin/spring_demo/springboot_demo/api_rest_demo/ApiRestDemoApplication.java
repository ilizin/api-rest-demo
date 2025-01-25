package me.ilizin.spring_demo.springboot_demo.api_rest_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		// This is not really necessary because spring starts scanning from the current package
		scanBasePackages = {"me.ilizin.spring_demo.springboot_demo.api_rest_demo"}
		)
public class ApiRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestDemoApplication.class, args);
	}

}
