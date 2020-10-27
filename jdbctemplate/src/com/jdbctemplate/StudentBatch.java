package com.jdbctemplate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentBatchHelper")
public class StudentBatch {
	
	@Autowired
	private StudentDaoImpl daoImpl;
	
	public void setUpStudenttable()
	{
		Student s = new Student();
		s.setRollNo(104);
		s.setName("Prathi");
		s.setOrgnization("Fss");
		
		Student s1 = new Student();
		s1.setRollNo(105);
		s1.setName("Abiya");
		s1.setOrgnization("Wipro");
		
		Student s2 = new Student();
		s2.setRollNo(106);
		s2.setName("abiya");
		s2.setOrgnization("citi");
		
		ArrayList<Student> slist = new ArrayList<Student>();
		slist.add(s);
		slist.add(s1);
		slist.add(s2);
		
		daoImpl.batchUpdate(slist);
	}
	
	
	void printStudentList()
	{
		List<Student> studentList = daoImpl.findAll();
		
		for(Student st : studentList)
		{
			System.out.println(st.toString());
		}
	}
	
	void printStudentObj(int id)
	{
		Student result = daoImpl.findByRollNo(id);
		System.out.println("FetchResultByID : "+result.toString());
	}
	
	void printFetchDataByName(String name)
	{
		List<Student> findByName = daoImpl.findByName(name);
		System.out.println("findByName : "+findByName.toString());
	}
}
