package org.spring12.redisnotwebconnect;

import java.util.Date;

import org.spring12.redisnotwebconnect.configuration.RedisSpringConfiguration;
import org.spring12.redisnotwebconnect.entity.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * java 桌面应用
 * @author kwz
 *
 */
public class MainEntry {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext configuration = new AnnotationConfigApplicationContext(RedisSpringConfiguration.class);
		RedisTemplate<String, Product> redis = configuration.getBean(RedisTemplate.class);
		Product product = new Product();
		product.setId(1001l);
		product.setName("mynameischina");
		product.setDate(new Date());
		redis.opsForValue().set(product.getName(), product);
		Product product2 = redis.opsForValue().get(product.getName());
		System.out.println("是否相等：" + product.equals(product2));
	}

}
