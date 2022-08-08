package com.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException  extends RuntimeException
{
	  
	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<APIResponse> resourceNotFoundException(ResourceNotFoundException e)
	    {
	    	      String message = e.getMessage();
	    	      APIResponse resonse = new APIResponse(message,false);
	    	      return new ResponseEntity<APIResponse>(resonse,HttpStatus.NOT_FOUND);
	    }
	

}
