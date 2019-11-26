package com.fullstack.devops.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
 
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long emp_id;
 
  @Column(name = "firstname")
  private String firstname;
 
  @Column(name = "lastname")
  private String lastname;
 

  @Column(name = "email")
  private String email;
 
  public Employee() {
  }

public Employee(String firstname, String lastname, String email) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
}

public long getEmp_id() {
	return emp_id;
}

public void setEmp_id(long emp_id) {
	this.emp_id = emp_id;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return "Employee [emp_id=" + emp_id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email+ "]";
}
 
}
 
 
 
 
  
