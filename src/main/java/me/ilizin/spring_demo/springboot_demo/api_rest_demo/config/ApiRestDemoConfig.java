package me.ilizin.spring_demo.springboot_demo.api_rest_demo.config;

import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.SqrtEroneService;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.services.ISqrtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiRestDemoConfig {

    // The bean id is sqrtEroneService, use @Bean("alternativeBeanId") to specify a different bean id
    @Bean
    public ISqrtService sqrtEroneService() {
        return new SqrtEroneService();
    }
}
