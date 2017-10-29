package org.spring12.redisnotwebconnect.beanfactory;

import org.spring12.redisnotwebconnect.entity.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisBeanFactory {
	@Bean
	public RedisConnectionFactory redisCF() {
		JedisConnectionFactory jcf =  new JedisConnectionFactory();
		jcf.setHostName("127.0.0.1");
		jcf.setPort(6379);
		return jcf;
	}
	
	@Bean
	public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory cf){
		RedisTemplate<String, Product> tmplate = new RedisTemplate<String, Product>();
		tmplate.setConnectionFactory(cf);
		return tmplate;
	}
}
