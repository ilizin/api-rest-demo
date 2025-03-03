package me.ilizin.spring_demo.springboot_demo.api_rest_demo;

import static org.assertj.core.api.Assertions.assertThat;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers.PalindromeRestController;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers.PrimeNumberRestController;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers.SqrtRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/* The @SpringBootTest annotation tells Spring Boot to look for a main configuration class (one with @SpringBootApplication,
 for instance) and use that to start a Spring application context. */
@SpringBootTest
class ApiRestDemoApplicationTests {

	@Autowired
	private PalindromeRestController palindromeRestController;
	@Autowired
	private PrimeNumberRestController primeNumberRestController;
	@Autowired
	private SqrtRestController sqrtRestController;

	@Test
	void contextLoads() {
		assertThat(palindromeRestController).isNotNull();
		assertThat(primeNumberRestController).isNotNull();
		assertThat(sqrtRestController).isNotNull();
	}

}
