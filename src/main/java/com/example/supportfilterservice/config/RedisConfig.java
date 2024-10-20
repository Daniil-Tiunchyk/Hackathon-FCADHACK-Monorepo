package com.example.supportfilterservice.config;

import com.example.supportfilterservice.domain.DTO.RegexConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, List<RegexConfig>> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, List<RegexConfig>> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }
}
