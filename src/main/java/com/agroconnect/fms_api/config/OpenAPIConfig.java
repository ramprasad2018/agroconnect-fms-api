package com.agroconnect.fms_api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "RedisDemo API",
        version = "1.0",
        description = "Spring Boot + PostgreSQL + Swagger in GitHub Codespaces"
    ),
    servers = {
        @Server(url = "/", description = "Default Server"),
        @Server(url = "http://localhost:8080", description = "Local Dev"),
        @Server(url = "https://zany-space-potato-...github.dev", description = "Codespace")
    }

)
public class OpenAPIConfig {
}