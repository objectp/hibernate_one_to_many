package com.objectp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.objectp.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		
		  SessionFactory factory = new Configuration()
				                   .configure("hibernate.cfg.xml")
				                   .addAnnotatedClass(Student.class)
				                   .buildSessionFactory();
		// Create a session 
		  Session session = factory.getCurrentSession();
		  
		try {
			
			int studentId = 1;
			
			// Get a new session and start transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Retrieve the student based on the id
			System.out.println("\nGetting student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student...");
			myStudent.setFirstName("Scoby"); // This update in memory
			
			// Commit the transaction/ no need to save it will save it automatically for update
			session.getTransaction().commit(); // This update in database
			
			// NEW CODE for bulck updating 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Update email for all students 
			System.out.println("Updating eail for all students ");
			session.createQuery("update student set email='teka@tamil.com")	
			       .executeUpdate();
			
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

		  
	}

}
	