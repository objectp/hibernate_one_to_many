package com.objectp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.objectp.hibernate.demo.entity.InstractorDetail;
import com.objectp.hibernate.demo.entity.Instructor;

public class CreateDemo {

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
			// Create the object
			Instructor thempInstructor = new Instructor("Teka", "Fiss", "teka@objecpt.com");
			
			InstractorDetail tempInstratorDetail = 
					new InstractorDetail(
							"http://www.luv2code.com/youtue", "lve"
							);
			// Associate the object together 
			thempInstructor.setInstractorDetail(tempInstratorDetail);
			
			// Start a transaction 
			session.beginTransaction();
			
			// Save the instructor 
			// Note: this will ALSO save the detail object
			// because of CascadeType.ALL
			// saving in two separate tables 
			
			session.save(thempInstructor);
			// Commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

		  
	}

}
	