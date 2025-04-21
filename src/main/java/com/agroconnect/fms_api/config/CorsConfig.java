package com.agroconnect.fms_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOriginPatterns("*") // ✅ Works better for dynamic domains like Codespaces
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .allowCredentials(false); // Optional: set to true if using cookies/tokens
            }
        };
    }
}