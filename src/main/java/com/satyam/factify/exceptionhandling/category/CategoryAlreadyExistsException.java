package com.satyam.factify.exceptionhandling.category;


public class CategoryAlreadyExistsException extends RuntimeException{

	public CategoryAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CategoryAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CategoryAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
