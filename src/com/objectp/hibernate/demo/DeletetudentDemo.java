package com.objectp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.objectp.hibernate.demo.entity.Student;

public class DeletetudentDemo {

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
			
			// Delete the student
			System.out.println("Delete student: " + myStudent);
			session.delete(myStudent);
			
			// NEW CODE
			// Deleting student with id  of 2 using alternate method
			System.out.println("Deleting student with id of 2: ");
			session.createQuery("delete from student where id=2").executeUpdate();
			
			// Commit the transaction/ no need to save it will save it automatically for update
			session.getTransaction().commit(); // This update in database
			
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

		  
	}

}
	