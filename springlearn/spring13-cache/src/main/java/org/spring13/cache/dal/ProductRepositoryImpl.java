package org.spring13.cache.dal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.spring13.cache.entity.Product;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryImpl implements ProductRepository {

	public static final AtomicLong al = new AtomicLong();
	public static final ConcurrentHashMap<Long, Product> map = new ConcurrentHashMap<Long, Product>();
	
	@CachePut(value = "productcache2", key = "#result.id")
	public Product save(Product product) {
		product.setId(al.incrementAndGet());
		System.out.println("save-id:" + Long.valueOf(product.getId()));
		map.put(Long.valueOf(product.getId()), product);
		return product;
	}

	@Cacheable(value = "productcache", key = "#root.args[0]")
	public Product findOne(long id) {
		System.out.println("findOne-id:" + Long.valueOf(id));
		return map.get(Long.valueOf(id));
	}

}
