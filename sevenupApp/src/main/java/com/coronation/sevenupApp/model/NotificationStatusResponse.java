package com.coronation.sevenupApp.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class NotificationStatusResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty
	private String Request;
	
	@JsonProperty
	private boolean NotificationReceived;
	
	@JsonProperty
	private boolean NotificationException;
	
	@JsonProperty
	private String LastErrorMessage;
	
	@JsonProperty
	private String LastErrorDate;

	public String getRequest() {
		return Request;
	}

	public void setRequest(String request) {
		Request = request;
	}

	public boolean isNotificationReceived() {
		return NotificationReceived;
	}

	public void setNotificationReceived(boolean notificationReceived) {
		this.NotificationReceived = notificationReceived;
	}

	public boolean isNotificationException() {
		return NotificationException;
	}

	public void setNotificationException(boolean notificationException) {
		this.NotificationException = notificationException;
	}

	public String getLastErrorMessage() {
		return LastErrorMessage;
	}

	public void setLastErrorMessage(String lastErrorMessage) {
		this.LastErrorMessage = lastErrorMessage;
	}

	public String getLastErrorDate() {
		return LastErrorDate;
	}

	public void setLastErrorDate(String lastErrorDate) {
		this.LastErrorDate = lastErrorDate;
	}
	
}
