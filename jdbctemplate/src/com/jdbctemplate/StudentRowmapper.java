package com.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowmapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

		Student s = new Student();

		s.setRollNo(rs.getInt("rollNo"));
		s.setName(rs.getString("name"));
		s.setOrgnization(rs.getString("orgnization"));

		return s;
	}

}
