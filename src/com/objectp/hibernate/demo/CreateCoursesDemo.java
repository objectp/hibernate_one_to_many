package com.objectp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.objectp.hibernate.demo.entity.Course;
import com.objectp.hibernate.demo.entity.InstractorDetail;
import com.objectp.hibernate.demo.entity.Instructor;

public class CreateCoursesDemo {

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

			// Get the instructor from db
			int theId = 1;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			// Create some courses
			Course tempCourse1 = new Course("Air Gittar- The ultimate guide");
			Course tempCourse2 = new Course("The pinball");
			
			// Add course to instructor 
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			// Save the course 
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
	