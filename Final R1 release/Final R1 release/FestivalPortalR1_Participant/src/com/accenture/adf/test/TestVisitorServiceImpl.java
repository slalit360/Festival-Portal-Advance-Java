package com.accenture.adf.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.adf.businesstier.entity.Event;
import com.accenture.adf.businesstier.entity.Visitor;
import com.accenture.adf.businesstier.service.VisitorServiceImpl;
import com.accenture.adf.helper.FERSDataConnection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Junit test class for VisitorServiceImpl
 *
 */
public class TestVisitorServiceImpl {

	private List<Event> visitorList;	
	private Visitor visitor;
	private VisitorServiceImpl visitorServiceImpl;

	/**
	 * Set up the initial methods 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {		
		visitorServiceImpl = new VisitorServiceImpl();
		visitor = new Visitor();
	}

	/**
	 * Deallocates the objects after execution of every method
	 * @throws Exception
	 */
	
	public void tearDown() throws Exception {
		visitorServiceImpl = null;
		visitor = null;
	}

	/**
	 * Test case for method createVisitor
	 */
	/*@Test
	public void testCreateVisitor() {
		visitor.setUserName("TestVisitor");
		visitor.setFirstName("TestVFname");
		visitor.setLastName("TestVLname");
		visitor.setPassword("ttt");
		visitor.setPhoneNumber("2344");
		visitor.setAddress("TestPlace");
		boolean status = visitorServiceImpl.createVisitor(visitor);
		Assert.assertFalse(status);
	}*/

	/**
	 * Test case for method createVisitor
	 */
	@Test
	public void testSearchVisitor() {
		visitor = visitorServiceImpl.searchVisitor("npatel", "password");
		Assert.assertEquals("npatel", visitor.getUserName());
	}

	/**
	 * Test case for method RegisterVisitor
	 */
	@Test
	public void testRegisterVisitor() {
		visitor = visitorServiceImpl.searchVisitor("npatel", "password");
		visitorServiceImpl.RegisterVisitor(visitor, 1001);
		visitorList = visitorServiceImpl.showRegisteredEvents(visitor);
		Assert.assertTrue(visitorList.size() > 0);
	}

	/**
	 * Test case for method showRegisteredEvents
	 */
	@Test
	public void testShowRegisteredEvents() {
		visitor = visitorServiceImpl.searchVisitor("npatel", "password");
		visitorList = visitorServiceImpl.showRegisteredEvents(visitor);
		Assert.assertTrue(visitorList.size() > 0);
	}

	/**
	 * Test case for method updateVisitorDetails
	 */
	@Test
	public void testUpdateVisitorDetails() {
		visitor = visitorServiceImpl.searchVisitor("npatel", "password");
		visitor.setFirstName("Updated First Name");
		int status = visitorServiceImpl.updateVisitorDetails(visitor);
		Assert.assertEquals(1, status);
	}

	/**
	 * Test case for method unregisterEvent
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testUnregisterEvent() throws SQLException, ClassNotFoundException {
		Connection connection=null;
		int testSeatsAvailableBefore=0,testSeatsAvailableAfter=0;
		 connection=FERSDataConnection.createConnection();
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement("SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?");
		statement.setInt(1, 1001);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			testSeatsAvailableBefore = resultSet.getInt("seatsavailable");
		}
		visitor = visitorServiceImpl.searchVisitor("slalit360", "12345678");
		visitorServiceImpl.unregisterEvent(visitor, 1001);
		statement = (PreparedStatement) connection.prepareStatement("SELECT SEATSAVAILABLE FROM EVENT WHERE EVENTID = ?");
		statement.setInt(1, 1001);
		resultSet = statement.executeQuery();
		while (resultSet.next()) {
			testSeatsAvailableAfter = resultSet.getInt("seatsavailable");
		}
		Assert.assertEquals(testSeatsAvailableAfter,testSeatsAvailableBefore);
	}

}
