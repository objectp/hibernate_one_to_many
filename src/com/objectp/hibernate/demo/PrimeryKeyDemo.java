package com.objectp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.objectp.hibernate.demo.entity.Student;

import org.hibernate.cfg.Configuration;

public class PrimeryKeyDemo {

	public static void main(String[] args) {
		
		  SessionFactory factory = new Configuration()
				                   .configure("hibernate.cfg.xml")
				                   .addAnnotatedClass(Student.class)
				                   .buildSessionFactory();
		// Create a session 
		  Session session = factory.getCurrentSession();
		  
		try {
			System.out.println("Creating 3 new students...");
			// Create a student object
			Student tempStudent1 = new Student("Teka", "Fiss", "teka@objectp.com");
			Student tempStudent2 = new Student("Jone", "Doe", "jone@objectp.com");
			Student tempStudent3 = new Student("Marry", "Bome", "marry@objectp.com");
			
			// Start a transaction 
			session.beginTransaction();
			
			// Save the student object
			System.out.println("Saving the student ...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// Commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

		 

	}

}
