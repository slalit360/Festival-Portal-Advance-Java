package com.accenture.adf.businesstier.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.service.EventFacade;
import com.accenture.adf.businesstier.service.EventServiceImpl;
import com.accenture.adf.exceptions.FERSGenericException;

/**
 *	<br/>
 *  CLASS DESCRIPTION: 	<br/>
 *	A controller class for receiving and handling all event related transactions from the User Interface 
 *	including finding all available events in the Event Catalog. <br/>
 *
 */

@Controller

public class EventController {

	private static Logger log = Logger.getLogger(EventController.class);
	
	/**
	 * 
	 * METHOD DESCRIPTION: <br/>
	 * The method will accept request and response from client and will 
	 * delegate to the service class to display all the events available 
	 * from the catalog to the visitor. <br/>
	 * 
	 * @param request (type HttpServletRequest)
	 * @param response (type HttpServletResponse)
	 *
	 * @return ModelAndView
	 * 
	 * @throws FERSGenericException
	 * 
	 * 
	 */
	
	@RequestMapping("/catalog.htm")
	
	public ModelAndView getAvailableEvents(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(request==null || response==null)
		{
			log.info("request or response not valid in GETAVAILABLEEVENTS METHOD ");
			throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
		}
		
		List<Event> eventList=new ArrayList<Event>();
		EventFacade serviceImpl=new EventServiceImpl();
		
		eventList=serviceImpl.getAllEvents();
		
		log.info("All Events are listed :"+eventList);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("allEvents",eventList);
		mv.setViewName("/eventCatalog.jsp");
		return mv;
	}
	
}
