package com.example.demo.jdbc.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.jdbc.model.Singer;

public class SingerMapper implements RowMapper<Singer> {

	@Override
	public Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Singer singer = new Singer();
		singer.setId(rs.getLong("id"));
		singer.setFirstName(rs.getString("first_name"));
		singer.setLastName(rs.getString("last_name"));
		singer.setBirthDate(rs.getDate("birth_date"));
		return singer;
	}

}
