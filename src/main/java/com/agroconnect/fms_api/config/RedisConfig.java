package com.agroconnect.fms_api.config;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRedisDocumentRepositories(basePackages = "com.agroconnect.fms_api")
public class RedisConfig {
    // Enables Redis OM repositories scanning
}