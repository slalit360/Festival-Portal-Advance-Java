package com.accenture.adf.exceptions;

import org.apache.log4j.Logger;

/**
 * <br/>
 * CLASS DESCRIPTION: <br/>
 * 
 * A customized Exception class that redirects how the ClassNotFoundException,
 * SQLException and Exception objects are handled in the application. <br/>
 * 
 */

@SuppressWarnings("serial")
public class FERSGenericException extends Exception {

	//LOGGER to handle custom exceptions
	private static Logger log = Logger.getLogger(FERSGenericException.class);
	
	public FERSGenericException(String message, Throwable object)
	{
		super(message,object);
		log.info("Exception Message is :"+message);
	}
	
}
