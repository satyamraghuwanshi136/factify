package com.satyam.factify.exceptionhandling;


public class CategoryNotFoundException extends RuntimeException{

	public CategoryNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CategoryNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CategoryNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
