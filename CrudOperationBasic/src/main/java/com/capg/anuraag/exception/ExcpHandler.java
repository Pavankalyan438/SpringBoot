package com.capg.anuraag.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcpHandler {
@ExceptionHandler(CustomerException.class)
public ResponseEntity<Object> myMessage(CustomerException c){
	return new ResponseEntity<>(c.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);	
	}
}