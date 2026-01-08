package me.ilizin.spring_demo.springboot_demo.api_rest_demo;

import static org.assertj.core.api.Assertions.assertThat;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers.NumberRestController;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers.StringRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/* The @SpringBootTest annotation tells Spring Boot to look for a main configuration class (one with @SpringBootApplication,
 for instance) and use that to start a Spring application context. */
@SpringBootTest
class ApiRestDemoApplicationTests {

	@Autowired
	private NumberRestController numberRestController;
	@Autowired
	private StringRestController stringRestController;

	@Test
	void contextLoads() {
		assertThat(numberRestController).isNotNull();
		assertThat(stringRestController).isNotNull();
	}
}
