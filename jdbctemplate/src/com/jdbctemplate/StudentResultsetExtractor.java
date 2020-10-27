package com.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;

public class StudentResultsetExtractor implements  ResultSetExtractor<List<Student>> {

	@Override
	public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {

		List<Student> studentList = new ArrayList<Student>();
		
		while(rs.next())
		{
			Student s = new Student();
			
			s.setRollNo(rs.getInt("rollNo"));
			s.setName(rs.getString("name"));
			s.setOrgnization(rs.getString("orgnization"));
			
			studentList.add(s);
		}
		return studentList	;
	}

	

}
