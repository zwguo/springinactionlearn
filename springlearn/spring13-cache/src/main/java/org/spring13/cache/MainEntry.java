package org.spring13.cache;

import java.util.Date;

import org.spring13.cache.configuration.CacheSpringConfiguration;
import org.spring13.cache.dal.ProductRepository;
import org.spring13.cache.entity.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 主入口
 * @author kwz
 *
 */
public class MainEntry {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(CacheSpringConfiguration.class);
		ProductRepository repository = config.getBean(ProductRepository.class);
		Product product = new Product();
		product.setName("mynameischina");
		product.setDate(new Date());
		System.out.println("保存第一个对象：");
		repository.save(product);
		System.out.println("获取第一个对象：");
		Product product2 = repository.findOne(product.getId());
		System.out.println("获取的对象和第一个对象比较：" + (product.equals(product2)));
		System.out.println("再次获取第一个对象：");
		product2 = repository.findOne(product.getId());
		System.out.println("获取的对象和第一个对象比较：" + (product.equals(product2)));
		
		System.out.println("保存第二个对象：");
		product.setName("mynameischina2");
		repository.save(product);
		System.out.println("获取第二个对象：");
		product2 = repository.findOne(product.getId());
		System.out.println("获取的对象和第二个对象比较：" + (product.equals(product2)));
		System.out.println("再次获取第二个对象：");
		product2 = repository.findOne(product.getId());
		System.out.println("获取的对象和第二个对象比较：" + (product.equals(product2)));
	}
}
