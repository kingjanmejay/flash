package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student tempStudent =new Student("Paul","Wall","Paul@luv2code.com");
			Student tempStudent2 =new Student("DINO","JAMES","Paul@luv2code.com");
			Student tempStudent3 =new Student("ARYA","VRAT","Paul@luv2code.com");
			Student tempStudent4 =new Student("SONA","MALIWAL","Paul@luv2code.com");
//			start a transaction
			session.beginTransaction();
//			save the student object
			System.out.println("Saving the student.....!");
			session.save(tempStudent);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.save(tempStudent4);
			
//			commit the transaction
			session.getTransaction().commit();
			System.out.println("Done.....!");
			
		}
		finally {
			
			factory.close();		}
	}

}







