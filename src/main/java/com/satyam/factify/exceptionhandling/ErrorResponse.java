package com.satyam.factify.exceptionhandling;

import java.util.List;

public class ErrorResponse {
	
	private String status;
	private String message;
	private String timeStamp;
	
	public ErrorResponse() {}
	
	

	public ErrorResponse(String status, String message, String timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
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
	
}
