package com.objectp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.objectp.hibernate.demo.entity.Course;
import com.objectp.hibernate.demo.entity.InstractorDetail;
import com.objectp.hibernate.demo.entity.Instructor;

public class DeleteCoursesDemo {

	public static void main(String[] args) {

		// Create session factory
		
		  SessionFactory factory = new Configuration()
				                   .configure("hibernate.cfg.xml")
				                   .addAnnotatedClass(Instructor.class)
				                   .addAnnotatedClass(InstractorDetail.class)
				                   .addAnnotatedClass(Course.class)
				                   .buildSessionFactory();
		// Create a session 
		  Session session = factory.getCurrentSession();
		  
		try {
			
			session.beginTransaction();
			
			// Get the course
			int theId = 10;
			Course theCourse = session.get(Course.class, theId);
			
			// Delete the course
			System.out.println("Deleting the course: " + theCourse);
			session.delete(theCourse);

			// Commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			// Add clean up code
			session.close();
			factory.close();
		}

		  
	}

}
	