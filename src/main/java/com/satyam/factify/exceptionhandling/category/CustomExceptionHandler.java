package com.satyam.factify.exceptionhandling.category;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.satyam.factify.exceptionhandling.ErrorResponse;
import com.satyam.factify.exceptionhandling.ValidationErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCategoryNotFoundException(CategoryNotFoundException exception) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setStatus(HttpStatus.NOT_FOUND.toString());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setTimeStamp(new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new java.util.Date()));

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
			ValidationErrorResponse errorResponse = new ValidationErrorResponse();
			List<String> errors = new ArrayList<>();
			
			
			exception.getBindingResult().getAllErrors().forEach((error)->{
				errors.add(error.getDefaultMessage());
			});
	
			errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
			errorResponse.setMessage("Validation Error");
			errorResponse.setTimeStamp(new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new java.util.Date()));
			errorResponse.setDetails(errors);
	
			return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
		
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleCommonException(Exception exception,
		HttpServletRequest httpServletRequest) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setTimeStamp(new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new java.util.Date()));
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
