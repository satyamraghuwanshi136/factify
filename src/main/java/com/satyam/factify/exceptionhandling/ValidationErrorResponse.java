package com.satyam.factify.exceptionhandling;

import java.util.List;

public class ValidationErrorResponse {
	
	private String status;
	private String message;
	private String timeStamp;
	private List<String> details;
	
	public ValidationErrorResponse() {}
	
	

	public ValidationErrorResponse(String status, String message, String timeStamp, List<String> details) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
		this.details = details;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}
	
	
	
}
