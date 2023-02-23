package com.cjc.homeloanproject.app.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestGlobalExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ApiError> CustomerNotFoundExceptionHandler(CustomerNotFoundException e,HttpServletRequest re)
	{
		ApiError e1=new ApiError();
		e1.setTimestamp(new Date());
		e1.setStatus(HttpStatus.NOT_FOUND.value());
		e1.setMessage(e.getMessage());
		e1.setError(HttpStatus.NOT_FOUND);
		e1.setPath(null);
		return new ResponseEntity<ApiError>(HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(GuarantorNotFoundException.class)
	public ResponseEntity<ApiError>  GuarantorNotFoundException(GuarantorNotFoundException g,HttpServletRequest re)
	{
		ApiError e2=new ApiError();
		e2.setTimestamp(new Date());
		e2.setMessage(g.getMessage());
		e2.setPath(null);
		e2.setStatus(HttpStatus.NOT_FOUND.value());
		e2.setError(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiError>(HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<ApiError>  AddressNotFoundException(AddressNotFoundException g,HttpServletRequest re)
	{
		ApiError e2=new ApiError();
		e2.setTimestamp(new Date());
		e2.setMessage(g.getMessage());
		e2.setPath(null);
		e2.setStatus(HttpStatus.NOT_FOUND.value());
		e2.setError(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiError>(HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EnquieryDetailsNotFoundException.class)
	public ResponseEntity<ApiError>  EnquieryDetailsNotFoundException(EnquieryDetailsNotFoundException g,HttpServletRequest re)
	{
		ApiError e2=new ApiError();
		e2.setTimestamp(new Date());
		e2.setMessage(g.getMessage());
		e2.setPath(null);
		e2.setStatus(HttpStatus.NOT_FOUND.value());
		e2.setError(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiError>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	

}
