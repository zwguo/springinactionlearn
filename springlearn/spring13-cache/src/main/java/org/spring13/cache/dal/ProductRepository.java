package org.spring13.cache.dal;

import org.spring13.cache.entity.Product;

public interface ProductRepository {
	Product save(Product product);

	Product findOne(long id);
}
