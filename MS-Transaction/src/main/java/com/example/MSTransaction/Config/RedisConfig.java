package com.example.MSTransaction.Config;

import com.example.MSTransaction.Domain.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
    @Bean
    JedisConnectionFactory jedisConnectionFactory()
    {
        return  new JedisConnectionFactory();
    }
    @Bean
    RedisTemplate<String, Transaction> redisTemplate() {
        final RedisTemplate<String, Transaction> redisTemplate=new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return  redisTemplate;
    }
}
