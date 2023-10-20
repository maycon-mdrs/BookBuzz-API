package com.web2.bookbuzz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://api.italodea.com.br") // Permita apenas do seu frontend
                        .allowedMethods("GET", "OPTIONS", "POST", "PUT", "PATCH", "DELETE")
                        .allowCredentials(true)
                        .maxAge(3600);
            }
        };
    }
}
