package org.spring10.jdbc.dal;

import org.spring10.jdbc.dal.entity.Spitter;
import org.springframework.jdbc.core.JdbcOperations;

public class JdbcSpitterRepository implements SpitterRepository{
	
	private JdbcOperations jdbcOperations;
	
	private final String INSERT_SPITTER = "insert into spitter values(NULL, ?, ?, ?, ?, NULL)";
	
	private final String SELECT_SPITTER_BY_ID = "select * from spitter where username = ?";
	
	public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	@Override
	public Spitter save(Spitter spitter) {
		jdbcOperations.update(INSERT_SPITTER, 
				spitter.getUsername(),
				spitter.getPassword(),
				spitter.getFirstName(),
				spitter.getLastName()
				);
		return spitter;
	}

	@Override
	public Spitter findByUsername(String username) {
		return jdbcOperations.queryForObject(SELECT_SPITTER_BY_ID, new SpitterRowMapper(), username);
	}

}
