package com.accenture.adf.businesstier.entity;

/**
 * <br/>
 * CLASS DESCRIPTION: <br/>
 * 
 * A Plain Old Java Object (POJO) entity class that stores (and helps to persist
 * in the application) some of the information from the Visitor Table. People is
 * the parent class of the Visitor Class. <br/>
 * 
 */

public class People {

	private String userName="";
	private String password="";
	private String firstName="";
	private String lastName="";
	private String email="";
	private String phoneNumber="";
	
	// Getter and Setter methods for encapsulated fields
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
