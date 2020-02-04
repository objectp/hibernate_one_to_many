package com.objectp.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	// Annotate the class as an entity and map to db table
	
	// Define the fields 
	
	// Annotate the fields with db columns 
	
	// ** setup mapping to InstructorDetail entity
	
	// Create constructors 
	
	// Generate getter/setter methods
	
	// Generate toString() methods 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstractorDetail instractorDetail;
	
	public Instructor() {
		
	}
	

	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public Instructor(String firstName, String lastName, String email, InstractorDetail instractorDetail) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.instractorDetail = instractorDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstractorDetail getInstractorDetail() {
		return instractorDetail;
	}

	public void setInstractorDetail(InstractorDetail instractorDetail) {
		this.instractorDetail = instractorDetail;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instractorDetail=" + instractorDetail + "]";
	}
	

}
