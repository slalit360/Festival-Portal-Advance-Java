package com.accenture.adf.businesstier.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.EventFacade;
import com.accenture.adf.businesstier.service.EventServiceImpl;
import com.accenture.adf.businesstier.service.VisitorFacade;
import com.accenture.adf.businesstier.service.VisitorServiceImpl;
import com.accenture.adf.exceptions.FERSGenericException;

/**
 *	<br/>
 *	CLASS DESCRIPTION:  <br/>
 *	A controller class for receiving and handling all visitor related transactions from the 
 *  User Interface including visitor account access, visitor account maintenance,  
 *  and visitor event registration requests. <br/>
 *  
 */

@Controller
public class VisitorController {

	private static Logger log = Logger.getLogger(VisitorController.class);
	
	/**
	 * <br/>
	 * METHOD DESCRIPTION: <br/>
	 * This method will receive request from Registration.jsp and directs to
	 * service class to register new Visitor into system
	 * by accepting details and persist into database <br/>
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
	@RequestMapping("/newVistor.htm")
	public ModelAndView newVisitor(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(request==null || response==null)
		{
			log.info("Request or Response failed for NEWVISITOR METHOD..");
			throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
		}
		String username=request.getParameter("USERNAME");
		String password=request.getParameter("PASSWORD");
		String firstname=request.getParameter("FIRSTNAME");
		String lastname=request.getParameter("LASTNAME");
		String email=request.getParameter("EMAIL");
		String phoneno=request.getParameter("PHONENO");
		String place=request.getParameter("PLACE");
		
		log.info("creating new visitor with UserName :"+username);
		
		Visitor visitor=new Visitor();
		visitor.setUserName(username);
		visitor.setPassword(password);
		visitor.setFirstName(firstname);
		visitor.setLastName(lastname);
		visitor.setEmail(email);
		visitor.setPhoneNumber(phoneno);
		visitor.setAddress(place);
		
		VisitorFacade vServiceImpl=new VisitorServiceImpl();
		boolean insertStatus=vServiceImpl.createVisitor(visitor);
		
		ModelAndView mv=new ModelAndView();
		if(insertStatus==true)
		{
		mv.addObject("REGISTRATIONSTATUSMESSAGE", "User Registered Succesfully !!!");
		log.info("Succesfully created visitor "+ username);
		mv.setViewName("/registration.jsp");
		}
		else
		{
		mv.addObject("REGISTRATIONSTATUSMESSAGE", "USERNAME already exists.. please register again with different USERNAME..");
		log.info("Username "+ username+" already exists and visitor creation failed..");
		mv.setViewName("/registration.jsp");
		}		
		return mv;
	}
	
	/**
	 * <br/>
	 * METHOD DESCRIPTION:<br/>
	 * The method is for authenticating visitor in the index.jsp page and redirects visitor to
	 * the homepage based on their credentials. if validation fails, redirects to index.jsp and
	 * error message is printed on page.<br/>
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
	
	@RequestMapping("/searchVisitor.htm")
	public ModelAndView searchVisitor(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(request==null || response==null)
		{
			log.info("Request or Response failed for SEARCHVISITOR METHOD..");
			throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
		}
		String username=request.getParameter("USERNAME");
		String password=request.getParameter("PASSWORD");
		HttpSession hs=request.getSession();//HttpSession is an interface
		if(hs.isNew())
		{
			log.info("session is new :"+username+" and password :"+password);
			hs.setAttribute("USERNAME", username);
			hs.setAttribute("PASSWORD", password);
		}
		else
		{
			username=hs.getAttribute("USERNAME").toString();
			password=hs.getAttribute("PASSWORD").toString();
		}
		
		log.info("Logging into FERS using username :"+username+" and password :"+password);
		
		Visitor visitor=new Visitor();
		VisitorFacade vServiceImpl=new VisitorServiceImpl();
		visitor=vServiceImpl.searchVisitor(username, password);
		
		ModelAndView mv=new ModelAndView();
		
		if(visitor.getVisitorId()==0)
		{
			mv.addObject("ERROR","Invalid Username / Password.");
			mv.setViewName("/index.jsp");
			return mv;
		}
		else
		{
		
		log.info("Visitor details available for the username :"+username);
			
		List<Event> eventList=new ArrayList<Event>();
		EventFacade serviceImpl=new EventServiceImpl();
		eventList=serviceImpl.getAllEvents();
		
		log.info("All events listed for th visitor :"+eventList);
		
		List<Event> regList=new ArrayList<Event>();
		regList=vServiceImpl.showRegisteredEvents(visitor);
		
		log.info("All Registered events listed for the visitor :"+regList);
		
		//HttpSession session=request.getSession();
		hs.setAttribute("VISITOR", visitor);
				
		mv.addObject("visitor",visitor);
		mv.addObject("allEvents",eventList);
		mv.addObject("regEvents",regList);
		mv.setViewName("./visitormain.jsp");
		return mv;
		}
	}
	
	/**
	 * <br/>
	 * METHOD DESCRIPTION:<br/>
	 * The method is used to register a visitor for an event from visitormain.jsp and maintains the list
	 * of all the events visitor registered. if user status is already registered for an event, then displays
	 * error message in visitormain.jsp page.<br/>
	 
	 * 
	 * @param request (type HttpServletRequest)
	 * @param response (type HttpServletResponse)
	 * 
	 * @return ModelAndView
	 * 
	 * @throws FERSGenericException
	 * 
	 */
	
	
	@RequestMapping("/eventreg.htm")
	public ModelAndView registerVisitor(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(request==null || response==null)
		{
			log.info("Request or Response failed for REGISTERVISITOR METHOD..");
			throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
		}
		
		HttpSession session=request.getSession();
		Visitor visitor=(Visitor)session.getAttribute("VISITOR");
		int eventid=Integer.parseInt(request.getParameter("eventId"));
		
		log.info("Visitor registered for the event :"+eventid);
		
		ModelAndView mv=new ModelAndView();
		
		VisitorFacade vServiceImpl=new VisitorServiceImpl();
		EventFacade serviceImpl=new EventServiceImpl();
		
		boolean regStatus=serviceImpl.checkEventsofVisitor(visitor, eventid);
		
		log.info("Status of the visitor for the event :"+regStatus);
		
		if(regStatus==false)
		{
			vServiceImpl.RegisterVisitor(visitor, eventid);
		log.info("Visitor succesfully registed for event :"+eventid);
		}
		else
		{
			mv.addObject("RegError", "User already Registered for the EVENT !!");
		}
		
		List<Event> regList=new ArrayList<Event>();
		regList=vServiceImpl.showRegisteredEvents(visitor);
		
		List<Event> eventList=new ArrayList<Event>();
		
		eventList=serviceImpl.getAllEvents();
		
		
		mv.addObject("visitor",visitor);
		mv.addObject("allEvents",eventList);
		mv.addObject("regEvents",regList);
		mv.setViewName("/visitormain.jsp");
		return mv;
		
	}
	
	/**
	 * <br/>
	 * METHOD DESCRIPTION:<br/>
	 * The method will update account details of the visitor and logout the visitor 
	 * and to force the visitor to re-login and confirm the updated account details 
	 * and new password.<br/>
	 * 
	 * @param request (type HttpServletRequest)
	 * @param response (type HttpServletResponse)
	 * 
	 * @return ModelAndView
	 * 
	 * @throws FERSGenericException
	 * 
	 */
		
	@RequestMapping("/updatevisitor.htm")
	public ModelAndView updateVisitor(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(request==null || response==null)
		{
			log.info("Request or Response failed for UPDATEVISITOR METHOD..");
			throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
		}
		
		HttpSession session=request.getSession();
		Visitor visitor=(Visitor)session.getAttribute("VISITOR");
		
		log.info("Updating visitor details with VisitorID :"+visitor.getVisitorId());
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String phoneno=request.getParameter("phoneno");
		String place=request.getParameter("address");
		
		visitor.setFirstName(firstname);
		visitor.setLastName(lastname);
		visitor.setUserName(username);
		visitor.setPassword(password);
		visitor.setEmail(email);
		visitor.setPhoneNumber(phoneno);
		visitor.setAddress(place);
		
		VisitorFacade vServiceImpl=new VisitorServiceImpl();
		int status=vServiceImpl.updateVisitorDetails(visitor);
		
		log.info("Number of Visitor records updated is :"+status);
		
		ModelAndView mv=new ModelAndView();
		
		if(status>0)
		{
			mv.addObject("status","success");
			mv.setViewName("/updatevisitor.jsp");
		}
		else
		{
			mv.addObject("updatestatus", "Error in updation.. Please Check fields and retry");
			mv.setViewName("/updatevisitor.jsp");
		}				
		return mv;
	}
	
	@RequestMapping("/changePWD.htm")
	public ModelAndView changePassword(HttpServletRequest request, HttpServletResponse response) {
		 int status = -1;
		 
		HttpSession session=request.getSession();
		Visitor visitor=(Visitor)session.getAttribute("VISITOR");
		
		if(visitor != null){
			log.info("Changing visitor password with VisitorID :"+visitor.getVisitorId());
			
			String password=request.getParameter("password");
			
			if(password != null){
				visitor.setPassword(password);		
				
				VisitorFacade vServiceImpl=new VisitorServiceImpl();
				
				try {
					status=vServiceImpl.changePassword(visitor);
				} catch (FERSGenericException e) {					
					status = -5;
					log.error(e.getMessage(), e);
				}
			}else{
				log.error("Password cannot be blank");
			}
			
			log.info("Visitor password changed :"+status);
		}else{
			log.error("Visitor details are invalid");
		}
		
		ModelAndView mv=new ModelAndView();
		
		if(status > 0){
			mv.addObject("status","success");
			mv.setViewName("/changePWD.jsp");
		}else if(status == -5){			
			mv.addObject("status", "error");
			mv.addObject("errorMsg", "System error occurred, Please verify log file for more details");
			mv.setViewName("/changePWD.jsp");
		}else if(status == -10){
			mv.addObject("status", "error");
			mv.addObject("errorMsg", "New password must be different from current password, please choose a different password and retry");
			mv.setViewName("/changePWD.jsp");
		}else{
			mv.addObject("status", "error");
			mv.addObject("errorMsg", "Error while changing password.. Please verify visitor and password details and retry again");			
			mv.setViewName("/changePWD.jsp");
		}
		return mv;		
	}
	
	
	
	
	
	/**
	 * <br/>
	 * METHOD DESCRIPTION: <br/>
	 * The method is to unregisters a visitor from an event within the visitormain.jsp 
	 * page and the seats will be released. The visitormain.jsp page is then refreshed 
	 * to confirm the updates. <br/>
	 * 
	 * @param request (type HttpServletRequest)
	 * @param response (type HttpServletResponse)
	 * 
	 * @return ModelAndView
	 * 
	 * @throws FERSGenericException
	 * 
	 */
	
	@RequestMapping("/eventunreg.htm")
	public ModelAndView unregisterEvent(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		if(request==null || response==null)
		{
			log.info("Request or Response failed for UNREGISTEREVENT METHOD..");
			throw new FERSGenericException("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", new NullPointerException());
		}
		
		HttpSession session=request.getSession();
		Visitor visitor=(Visitor)session.getAttribute("VISITOR");
		int eventid=Integer.parseInt(request.getParameter("eventId"));
		
		log.info("Unregistering for the event :"+eventid);
		
		VisitorFacade vServiceImpl=new VisitorServiceImpl();
		vServiceImpl.unregisterEvent(visitor, eventid);
		
		
		
		List<Event> regList=new ArrayList<Event>();
		regList=vServiceImpl.showRegisteredEvents(visitor);
		
		List<Event> eventList=new ArrayList<Event>();
		EventFacade serviceImpl=new EventServiceImpl();
		
		serviceImpl.updateEventDeletions(eventid);
		
		log.info("Seats allocated for the event are released :"+eventid);
		
		eventList=serviceImpl.getAllEvents();
		
		
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("visitor",visitor);
		mv.addObject("allEvents",eventList);
		mv.addObject("regEvents",regList);
		mv.setViewName("/visitormain.jsp");
		return mv;
	}
	

}
