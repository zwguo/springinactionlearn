package org.spring11.hibernate.dal;

import org.spring11.hibernate.dal.entity.Spitter;

public interface SpitterRepository {
	Spitter save(Spitter spitter);
	
	Spitter findByUsername(String username);
}
