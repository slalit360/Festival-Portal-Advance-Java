package com.accenture.adf.businesstier.service;

import java.util.List;

import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
/**
 * <br/>
 * CLASS DESCRIPTION: <br/>
 * 
 * An interface for defining and enforcing operations needed for 
 * the Event Service class.  It provides the scope of possible 
 * database requests made through the EventDAO.<br/>
 * 
 * 
 */

public interface EventFacade {
	
	public List<Event> getAllEvents();
	
	public boolean checkEventsofVisitor(Visitor visitor, int eventid);
	
	public void updateEventDeletions(int eventid);

}
