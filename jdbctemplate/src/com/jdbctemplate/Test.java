package com.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		System.out.println("Beans.xml file loaded...");
		StudentDaoImpl stdimpl = context.getBean("studentdaoobj", StudentDaoImpl.class);
		
		StudentBatch studentBatch = context.getBean("studentBatchHelper",StudentBatch.class);
	//	studentBatch.setUpStudenttable();
	//	studentBatch.printStudentList();
	//	studentBatch.printStudentObj(103);
		studentBatch.printFetchDataByName("Prathi");
		
	/*	Student student = new Student();
		student.setRollNo(105);
		student.setName("abiyakarolin");
		student.setOrgnization("Pratheeban");
		
		stdimpl.insert(student); 
	*/
		
	/*	boolean deleteRecordByRollNo = stdimpl.deleteRecordByRollNo(105);
		if(deleteRecordByRollNo)
			System.out.println("Record Deleted successfully...");
	*/
		
	
	//	stdimpl.cleanUp();
		
	//stdimpl.delectByCondition(101, "wipro");
		
		
		
		
	}

}
