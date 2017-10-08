package org.spring04.webmvc.data;

import org.spring04.webmvc.Spitter;

public interface SpitterRepository {
	Spitter save(Spitter spitter);
	
	Spitter findByUsername(String username);
}
