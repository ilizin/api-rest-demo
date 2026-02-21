package me.ilizin.spring_demo.springboot_demo.api_rest_demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.SqrtEroneService;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.ISqrtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* It's a class level annotation indicating that an object is a source of bean definitions, so a class marked with @Configuration
   declares beans through @Bean annotated methods and can also be used to define inter-bean dependencies. */
@Configuration
public class ApiRestDemoConfig implements WebMvcConfigurer {

    // The bean id is sqrtEroneService, use @Bean("alternativeBeanId") to specify a different bean id
    @Bean
    public ISqrtService sqrtEroneService() {
        return new SqrtEroneService();
    }

    @Bean
    public OpenAPI customOpenAPI() throws IOException {
        ClassPathResource resource = new ClassPathResource("api-rest-demo-swagger.yaml");
        Path path = Paths.get(resource.getURI());
        String content = new String(Files.readAllBytes(path));
        SwaggerParseResult result = new OpenAPIV3Parser().readContents(content);
        if (result.getMessages().isEmpty() && result.getOpenAPI() != null) {
            return result.getOpenAPI();
        } else {
            throw new RuntimeException("Failed to parse OpenAPI definition: " + result.getMessages());
        }
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api-docs/**").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/webjars/springdoc-openapi-ui/");
    }
}
