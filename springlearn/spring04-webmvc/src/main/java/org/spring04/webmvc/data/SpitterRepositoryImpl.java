package org.spring04.webmvc.data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.spring04.webmvc.Spitter;
import org.springframework.stereotype.Component;

@Component
public class SpitterRepositoryImpl implements SpitterRepository {

	public static AtomicLong NOWID = new AtomicLong();

	public static ConcurrentHashMap<Long, Spitter> MAP = new ConcurrentHashMap<>();
	
	public static ConcurrentHashMap<String, Spitter> NAMEDMAP = new ConcurrentHashMap<>();

	@Override
	public Spitter save(Spitter spitter) {
		System.out.println("SpitterRepositoryImpl-save:" + spitter);
		Spitter saved = new Spitter(NOWID.incrementAndGet(), spitter.getUsername(), spitter.getPassword(), spitter.getFirstName(), spitter.getLastName());
		MAP.put(saved.getId(), saved);
		NAMEDMAP.put(saved.getUsername(), saved);
		return saved;
	}

	@Override
	public Spitter findByUsername(String username) {
		return NAMEDMAP.get(username);
	}

}
