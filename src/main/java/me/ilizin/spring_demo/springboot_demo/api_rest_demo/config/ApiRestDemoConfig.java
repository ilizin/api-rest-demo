package me.ilizin.spring_demo.springboot_demo.api_rest_demo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.SqrtEroneService;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.ISqrtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* It's a class level annotation indicating that an object is a source of bean definitions, so a class marked with @Configuration
   declares beans through @Bean annotated methods and can also be used to define inter-bean dependencies. */
@Configuration
public class ApiRestDemoConfig {

    // The bean id is sqrtEroneService, use @Bean("alternativeBeanId") to specify a different bean id
    @Bean
    public ISqrtService sqrtEroneService() {
        return new SqrtEroneService();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                        .version("1.0.0-SNAPSHOT")
                        .title("Api rest with JPA demo")
                        .description("A CRUD API rest with Jpa/hibernate (h2) demo project")
                        .contact(new Contact()
                                .name("Contact the developer")
                                .url("https://github.com/ilizin"))
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")))
                .externalDocs(new ExternalDocumentation()
                        .description("Find out more about Swagger")
                        .url("https://swagger.io/"));
    }
}
