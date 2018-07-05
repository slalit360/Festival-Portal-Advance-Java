package com.accenture.adf.businesstier.entity;

import java.util.ArrayList;
/**
 * <br/>
 * CLASS DESCRIPTION: <br/>
 * 
 * A Plain Old Java Object (POJO) entity class that stores (and helps to persist
 * in the application) more information from the Visitor Table. <br/>
 * 
 */

public class Visitor extends People {

	private int visitorId;
	private ArrayList<Event> registeredEvents=null;
	private String address;
	
	public int getVisitorId() {
		return visitorId;
	}
	
	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public ArrayList<Event> getRegisteredEvents() {
		return registeredEvents;
	}
	
	public void setRegisteredEvents(ArrayList<Event> registeredEvents) {
		this.registeredEvents = registeredEvents;
	}	
	
}
