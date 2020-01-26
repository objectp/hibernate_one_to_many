package com.objectp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.objectp.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		
		  SessionFactory factory = new Configuration()
				                   .configure("hibernate.cfg.xml")
				                   .addAnnotatedClass(Student.class)
				                   .buildSessionFactory();
		// Create a session 
		  Session session = factory.getCurrentSession();
		  
		try {
			System.out.println("Creating new student object");
			// Create a student object
			Student tempStudent = new Student("Teka", "Fiss", "teka@objectp.com");
			
			// Start a transaction 
			session.beginTransaction();
			
			// Save the student object
			System.out.println("Saving the student ...");
			session.save(tempStudent);
			
			// Commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

		  
	}

}
	