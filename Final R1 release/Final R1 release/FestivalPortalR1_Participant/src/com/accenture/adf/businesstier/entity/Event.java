package com.accenture.adf.businesstier.entity;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * <br/>
 * CLASS DESCRIPTION: <br/>
 * 
 * A Plain Old Java Object (POJO) entity class that stores 
 * (and helps to persist in the application) some or all 
 * information from the Event Table in the database.<br/>
 * 
 */

public class Event {
	
	private int eventid;
	private String name="";
	private String description="";
	private String place="";
	private String duration;
	private String eventtype="";
	private int seatsavailable;
	private int signupid;
	
	private Set<Visitor> visitors=new HashSet<Visitor>();
	
	// Getter and Setter methods for encapsulated fields
	
	public int getEventid() {
		return eventid;
	}
	
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getEventtype() {
		return eventtype;
	}
	
	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}
	
	public int getSeatsavailable() {
		return seatsavailable;
	}
	
	public void setSeatsavailable(int seatsavailable) {
		this.seatsavailable = seatsavailable;
	}
	
	public Set<Visitor> getVisitors() {
		return visitors;
	}
	
	public void setVisitors(Set<Visitor> visitors) {
		this.visitors = visitors;
	}
	
	public int getSignupid() {
		return signupid;
	}
	
	public void setSignupid(int signupid) {
		this.signupid = signupid;
	}

}
