package com.cjc.homeloanproject.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
	
	private Date timestamp;
	private Integer status;
	private HttpStatus error;
	private String message;
	private String path;
	

}
