package me.ilizin.spring_demo.springboot_demo.api_rest_demo;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/* It's a convenience annotation that adds all of the following:
- Configuration
- EnableAutoConfiguration
- ComponentScan */
@SpringBootApplication(
		// This is not really necessary because spring starts scanning from the current package
		scanBasePackages = {"me.ilizin.spring_demo.springboot_demo.api_rest_demo"}
		)
public class ApiRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestDemoApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(/*@Value("${springdoc.version}") String appVersion*/) {
		return new OpenAPI().info(new Info()
				.title("Api rest demo API")
				.description("A demo project for setting up an api rest with Spring Boot")
				.contact(new Contact()
						.name("ilizin")
						.url("https://github.com/ilizin"))
				.termsOfService("http://swagger.io/terms/")
				.license(new License()
						.name("Apache 2.0")
						.url("http://www.apache.org/licenses/LICENSE-2.0.html")));
	}
}
