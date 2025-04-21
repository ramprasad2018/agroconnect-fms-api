package com.agroconnect.fms_api.config;



import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisIndexInitializer {


    @PostConstruct
    public void createIndexes() {
        // indexer.createIndexFor(Supplier.class);
        // Add more model classes here if needed later
    }
}