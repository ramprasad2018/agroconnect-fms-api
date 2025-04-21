package com.example.springboot_redisom_practice.config;

import com.example.springboot_redisom_practice.model.Supplier;
import com.redis.om.spring.RediSearchIndexer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisIndexInitializer {

    @Autowired
    private RediSearchIndexer indexer;

    @PostConstruct
    public void createIndexes() {
        indexer.createIndexFor(Supplier.class);
        // Add more model classes here if needed later
    }
}