package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
//import javax.servlet.http.HttpServletRequest; 

import com.accenture.adf.businesstier.controller.EventController;

/**
 * Junit test class for EventController 
 *
 */
public class TestEventController {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private ModelAndView modelAndView;
	private EventController controller;

	/**
	 * Sets up initial objects required in other methods
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		modelAndView = new ModelAndView();
		controller = new EventController();
		response = new MockHttpServletResponse();
		request = new MockHttpServletRequest("GET", "/catalog.htm");
	}

	/**
	 * Deallocate the objects after execution of every method
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		modelAndView = null;
		controller = null;
		response = null; 
		request = null;
	}

	/**
	 * Test case to test the positive scenario for getAvailableEvents  method
	 */
	@Test
	public void testGetAvailableEvents_Positive() {

		try {
			modelAndView = controller.getAvailableEvents(request, response);
		} catch (Exception exception) {
			fail("Exception");
		}
		assertEquals("/eventCatalog.jsp", modelAndView.getViewName());
	}

	/**
	 * Executes the negative scenario for getAvailableEvents method
	 */
	@Test
	public void testGetAvailableEvents_Negative() {

		try {
			modelAndView = controller.getAvailableEvents(null, response);
		} catch (Exception exception) {
			assertEquals("Error in Transaction, Please re-Try. for more information check Logfile in C:\\FERSLOG folder", exception.getMessage());
		}
		assertEquals(null, modelAndView.getViewName());
	}

}
