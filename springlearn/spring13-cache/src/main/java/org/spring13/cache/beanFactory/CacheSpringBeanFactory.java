package org.spring13.cache.beanFactory;

import org.spring13.cache.entity.Product;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CacheSpringBeanFactory {

//	@Bean
//	public CacheManager cacheManager() {
//		return new ConcurrentMapCacheManager();
//	}
	
	//use redis
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName("127.0.0.1");
		factory.setPort(6379);
		factory.afterPropertiesSet();
		return factory;
	}
	
	@Bean
	public RedisTemplate redisTemplate(RedisConnectionFactory factory ){
		RedisTemplate template = new RedisTemplate();
		template.setConnectionFactory(factory);
		template.afterPropertiesSet();
		return template;
	}
	
	@Bean
	public CacheManager cacheManager(RedisOperations operations) {
		return new RedisCacheManager(operations);
	}
}
