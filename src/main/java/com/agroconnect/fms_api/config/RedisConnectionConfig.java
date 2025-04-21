package com.example.springboot_redisom_practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class RedisConnectionConfig {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName("redis-19543.c273.us-east-1-2.ec2.redns.redis-cloud.com");
        config.setPort(19543);
        config.setUsername("default"); // ✅ usually this is "default" in Redis Cloud
        config.setPassword(RedisPassword.of("eS2ecv9x46PrbXVvmCMh6oX3b1eMDzjw")); // 🔐 Replace this with your actual password
        return new JedisConnectionFactory(config);
    }
}