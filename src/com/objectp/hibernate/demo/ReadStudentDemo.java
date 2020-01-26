package com.objectp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.objectp.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Abbebe", "Bekele", "abebe@objectp.com");
			
			// Start a transaction 
			session.beginTransaction();
			
			// Save the student object
			System.out.println("Saving the student ...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// Commit the transaction 
			session.getTransaction().commit();
			
			// READING CODE
			
			// Find the student id/primary key
			System.out.println("Saved student generated id: " + tempStudent.getId());
			
			// Get a new session and start transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Retrieve the student based on the id
			System.out.println("\nGetting student with id: " + tempStudent.getId());

			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("The Get complited " + myStudent);
			
			// Commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

		  
	}

}
	