package com.jdbctemplate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("studentdaoobj")
public class StudentDaoImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(Student std) {
		String sql = "INSERT INTO STUDENT VALUES (?,?,?)";

		System.out.println("Student args " + std.toString());

		Object[] arg = { std.getRollNo(), std.getName(), std.getOrgnization() };

		int count = jdbcTemplate.update(sql, arg);
		if (count > 0)
			System.out.println(count + " Record(s) inserted successfully...");
	}

	@Override
	public boolean deleteRecordByRollNo(int rollNo) {

		String sql = "DELETE FROM STUDENT WHERE ROLLNO = ?";

		int isRecordDeleted = jdbcTemplate.update(sql, rollNo);

		return isRecordDeleted > 0;
	}
	
	@Override
	public void delectByCondition(int rollNo, String orgnization) {

		String sql = "DELETE FROM STUDENT WHERE ROLLNO = ? OR ORGNIZATION = ?";
		
		int isdeleteCount = jdbcTemplate.update(sql, rollNo, orgnization);
		
		System.out.println(isdeleteCount + " Record(s) deleted successfully...");
	}

	@Override
	public void cleanUp() {

		String sql = "TRUNCATE TABLE STUDENT";

		jdbcTemplate.execute(sql);

		System.out.println("table cleanedUp...");

	}

	@Override
	public void batchUpdate(List<Student> student) {
		
		String sql = "INSERT INTO STUDENT VALUES (?,?,?)";
		
		ArrayList<Object[]> stdargs = new ArrayList<>();
		for(Student tempStudent : student)
		{
			Object[] studentData = {tempStudent.getRollNo(),tempStudent.getName(),tempStudent.getOrgnization()};
			stdargs.add(studentData);
		}
		
		jdbcTemplate.batchUpdate(sql, stdargs);
		
		System.out.println("batch inserted successfully...");
		
	}

	@Override
	public List<Student> findAll() {

		String sql = "SELECT * FROM STUDENT";
		
	//	List<Student> StudentList = jdbcTemplate.query(sql, new StudentRowmapper());
		List<Student> StudentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
		
		return StudentList;
	}

	@Override
	public Student findByRollNo(int rollNo) {

		String sql = "SELECT * FROM STUDENT WHERE ROLLNO = ?"; 
		//CAN USE ALIAS NAME WHEN PROPERTY NAME DOES NOT SAME AS TABLE COLUMN NAME WHILE USING BEAN PROPERTY ROWMAPPER
		
		Student studentRecord = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class),rollNo);
		
		return studentRecord;
	}

	@Override
	public List<Student> findByName(String name) {

		String sql = "SELECT * FROM STUDENT WHERE NAME = ?";
		
		List<Student> studentList = jdbcTemplate.query(sql, new StudentResultsetExtractor() , name);
		
		return studentList;
	}

	
}
