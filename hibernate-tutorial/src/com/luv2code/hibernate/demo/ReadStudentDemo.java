package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

//		create session factory
		SessionFactory factory = new Configuration()
				                     .configure("hibernate.cfg.xml")
				                     .addAnnotatedClass(Student.class)
				                     .buildSessionFactory();
		
//		create session
		
		Session session = factory.getCurrentSession();
		
		try {
//			create a student object
			System.out.println("creating new student object");
			Student tempStudent =new Student("Ankur","Tiwari","Ankur@luv2code.com");
//			start a transaction
			session.beginTransaction();
//			save the student object
			System.out.println("Saving the student.....!");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
//			commit the transaction
			session.getTransaction().commit();
//			My new code to read the student
			
//			find out student id primary key
			System.out.println("Saved student generated id :" + tempStudent.getId());
//			get new session and start transaction
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			System.out.println("\n Getiing student with id: " + tempStudent.getId() );
			Student mystudent =session.get(Student.class, 5);
			
			
			System.out.println("Get Complete..!"+mystudent);
			System.out.println("Done.....!");
			session.getTransaction().commit();
		}
		finally {
			
			factory.close();		}
	}

}







