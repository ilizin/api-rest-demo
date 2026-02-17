package me.ilizin.spring_demo.springboot_demo.api_rest_demo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.SqrtEroneService;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.ISqrtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* It's a class level annotation indicating that an object is a source of bean definitions, so a class marked with @Configuration
   declares beans through @Bean annotated methods and can also be used to define inter-bean dependencies. */
@Configuration
public class ApiRestDemoConfig {

    // The bean id is sqrtEroneService, use @Bean("alternativeBeanId") to specify a different bean id
    @Bean
    public ISqrtService sqrtEroneService() {
        return new SqrtEroneService();
    }

    @Autowired
    private BuildProperties buildProperties;

    @Bean
    public OpenAPI customOpenAPI() throws IOException {
        ClassPathResource resource = new ClassPathResource("api-rest-with-jpa-demo-swagger.yaml");
        Path path = Paths.get(resource.getURI());
        String content = new String(Files.readAllBytes(path));
        SwaggerParseResult result = new OpenAPIV3Parser().readContents(content);
        if (result.getMessages().isEmpty() && result.getOpenAPI() != null) {
            OpenAPI openAPI = result.getOpenAPI();
            openAPI.getInfo().setTitle(buildProperties.getName());
            openAPI.getInfo().setVersion(buildProperties.getVersion());
            //openAPI.getInfo().setDescription(buildProperties.get("description"));
            return openAPI;
        } else {
            throw new RuntimeException("Failed to parse OpenAPI definition: " + result.getMessages());
        }
    }
}
