package org.spring10.jdbc.dal;

import org.spring10.jdbc.dal.entity.Spitter;

public interface SpitterRepository {
	Spitter save(Spitter spitter);
	
	Spitter findByUsername(String username);
}
