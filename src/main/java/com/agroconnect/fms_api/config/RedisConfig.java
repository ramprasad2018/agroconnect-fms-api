package com.example.springboot_redisom_practice.config;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRedisDocumentRepositories(basePackages = "com.example.springboot_redisom_practice.repository")
public class RedisConfig {
    // Enables Redis OM repositories scanning
}