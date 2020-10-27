package com.jdbctemplate;

import java.util.List;

public interface StudentDAO {
	
	void insert(Student std);
	
	boolean deleteRecordByRollNo(int rollNo);
	
	void delectByCondition(int rollNo, String orgnization);
	
	void cleanUp();

	void batchUpdate(List<Student> student);
	
	List<Student> findAll();
	
	Student findByRollNo(int rollNo);
	
	List<Student>findByName(String name);
}
