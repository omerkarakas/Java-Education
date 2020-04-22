package com.omer.aopdemo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.omer.aopdemo.dao.StudentDAO;
import com.omer.aopdemo.domain.Student;

public class AOPDemoApp {

	public static void main(String[] args) {


		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AOPDemoConfig.class);
		
		System.out.println("Context started");
		
		//StudentDAO stdDAO =  ctx.getBean("studentDAO",StudentDAO.class);
		Student std = ctx.getBean("student",Student.class);
		

		//System.out.println(std.getIsim());
		System.out.println(std.getId());
				
		
		//System.out.println(std.getSoyisim());
		/*
		stdDAO.addStudent(new Student());
		
		stdDAO.addStudent("merhaba");
		
		stdDAO.deleteStudent(new Student());
		*/
		ctx.close();
		System.out.println("Context closed");
		
	}

}
