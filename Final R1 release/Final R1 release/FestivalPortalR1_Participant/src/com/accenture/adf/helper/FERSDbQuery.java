package com.accenture.adf.helper;

/**
 * <br/>
 * CLASS DESCRIPTION: <br/>
 * 
 * A helper class that makes available to the application SQL 
 * queries that are externalized and centrally maintained 
 * using the Spring Framework. <br/>
 * 
 */

public class FERSDbQuery {
	// SQL queries for EVENTDAO
	private String searchEvent = "";
	private String updateEvent = "";
	private String checkEvent = "";
	private String updateDeleteEvent = "";

	// SQL queries for VISITORDAO
	private String insertQuery = "";
	private String searchQuery = "";
	private String registerQuery = "";
	private String statusQuery = "";
	private String updateQuery = "";
	private String deleteEventQuery = "";
	private String validateVisitor = "";
	private String changePWDQuery="";
	private String verifyPWDQuery="";
	public String getChangePWDQuery() {
		return changePWDQuery;
	}

	public void setChangePWDQuery(String changePWDQuery) {
		this.changePWDQuery = changePWDQuery;
	}

	public String getVerifyPWDQuery() {
		return verifyPWDQuery;
	}

	public void setVerifyPWDQuery(String verifyPWDQuery) {
		this.verifyPWDQuery = verifyPWDQuery;
	}

	

	public String getSearchEvent() {
		return searchEvent;
	}

	public void setSearchEvent(String searchEvent) {
		this.searchEvent = searchEvent;
	}

	public String getUpdateEvent() {
		return updateEvent;
	}

	public void setUpdateEvent(String updateEvent) {
		this.updateEvent = updateEvent;
	}

	public String getCheckEvent() {
		return checkEvent;
	}

	public void setCheckEvent(String checkEvent) {
		this.checkEvent = checkEvent;
	}

	public String getUpdateDeleteEvent() {
		return updateDeleteEvent;
	}

	public void setUpdateDeleteEvent(String updateDeleteEvent) {
		this.updateDeleteEvent = updateDeleteEvent;
	}

	public String getInsertQuery() {
		return insertQuery;
	}

	public void setInsertQuery(String insertQuery) {
		this.insertQuery = insertQuery;
	}

	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

	public String getRegisterQuery() {
		return registerQuery;
	}

	public void setRegisterQuery(String registerQuery) {
		this.registerQuery = registerQuery;
	}

	public String getStatusQuery() {
		return statusQuery;
	}

	public void setStatusQuery(String statusQuery) {
		this.statusQuery = statusQuery;
	}

	public String getUpdateQuery() {
		return updateQuery;
	}

	public void setUpdateQuery(String updateQuery) {
		this.updateQuery = updateQuery;
	}

	public String getDeleteEventQuery() {
		return deleteEventQuery;
	}

	public void setDeleteEventQuery(String deleteEventQuery) {
		this.deleteEventQuery = deleteEventQuery;
	}

	public String getValidateVisitor() {
		return validateVisitor;
	}

	public void setValidateVisitor(String validateVisitor) {
		this.validateVisitor = validateVisitor;
	}

}
