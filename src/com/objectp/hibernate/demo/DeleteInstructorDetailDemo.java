package com.objectp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.objectp.hibernate.demo.entity.InstractorDetail;
import com.objectp.hibernate.demo.entity.Instructor;

public class DeleteDemo {

	public static void main(String[] args) {

		// Create session factory
		
		  SessionFactory factory = new Configuration()
				                   .configure("hibernate.cfg.xml")
				                   .addAnnotatedClass(Instructor.class)
				                   .addAnnotatedClass(InstractorDetail.class)
				                   .buildSessionFactory();
		// Create a session 
		  Session session = factory.getCurrentSession();
		  
		try {
			
			// Start a transaction 
			session.beginTransaction();
			
   int theId = 2;

   // Get the instructor's detail object
   InstructorDetail theInstructorDetail =
              session.get(InstructorDetail.class, theId);

   // Print the instructor detail 
   System.out.println("tempInstructorDetail: "+tempInstructorDetail);


   // Print the associated instructor
   System.out.println("the associated instructor: " +
         tempInstructorDetail.getInstructor());
   
   // Delete the instructor detail
   System.out.println("I'm deleteing tempInstractorDetail " + tempInstructorDetail);
   session.delete(tempInstructorDetail);

			// Commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
		catch(Exception exe) {
			exe.printStackTrace();
		}
			
		}finally {
			// Handle connection leak issue
			session.close();
			
			factory.close();
		}

		  
	}

}
	
