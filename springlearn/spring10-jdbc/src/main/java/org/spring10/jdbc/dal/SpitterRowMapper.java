package org.spring10.jdbc.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.spring10.jdbc.dal.entity.Spitter;
import org.springframework.jdbc.core.RowMapper;

public final class SpitterRowMapper implements RowMapper<Spitter>{

	@Override
	public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
		Spitter spitter = new Spitter();
		spitter.setId(Long.valueOf(rs.getInt("id")));
		spitter.setUsername(rs.getString("username"));
		spitter.setFirstName(rs.getString("firstname"));
		spitter.setLastName(rs.getString("lastname"));
		spitter.setPassword(rs.getString("password"));
		return spitter;
	}

}
