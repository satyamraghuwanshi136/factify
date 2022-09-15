package com.satyam.factify.exceptionhandling;


public class FactNotFoundException extends RuntimeException{

	public FactNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FactNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FactNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
