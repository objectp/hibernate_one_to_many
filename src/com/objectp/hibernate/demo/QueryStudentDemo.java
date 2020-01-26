package com.objectp.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.objectp.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			
			// Start a transaction 
			session.beginTransaction();
			
		    // Query students 
			List<Student> theStudents = session.createQuery("from student").list();
			
			// Display students 
			displayStudents(theStudents);
			
			// Query students whose lastName is Doe
			theStudents = session.createQuery("from student s where s.lastName='Doe'").list();
			
			// Display students 
			System.out.println("\n\nThe students who have last name of Doe");
			displayStudents(theStudents);
			
			// Query students whose last name is Doe or fristName is Daffie
			theStudents = session.createQuery("from student s where" 
			+ " s.lastName='Doe' OR s.firstName='Daffy'").list();

			// Display students 
			System.out.println("\n\nThe students who have last name of Doe or fistName is Daffy");
			displayStudents(theStudents);
			
			// Query the students where email like %objectp.com
			theStudents = session.createQuery("from student s where s.email" 
					+ " LIKE '%objectp.com'").list();

			// Display students 
			System.out.println("\n\nThe students whose email is like %objectp.com");
			displayStudents(theStudents);

			// Commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

		  
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student theStudent: theStudents) {
			System.out.println(theStudent);
		}
	}

}
	