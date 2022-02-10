package com.reliance.training.redis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

	@Bean
	public RedisConnectionFactory connectionFac() {
		return new LettuceConnectionFactory();
	}

	@Bean
	public RedisTemplate<String, Order> template() {
		RedisTemplate<String, Order> template = new RedisTemplate<String, Order>();
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setConnectionFactory(connectionFac());
		return template;
	}

}
