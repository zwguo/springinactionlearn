package org.spring10.jdbc.dal;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpittrBeanProvider {

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public SpitterRepository getSpitterRepository(JdbcTemplate jdbcTemplate) {
		return new JdbcSpitterRepository(jdbcTemplate);
	}
}
