package com.BookApp.Registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.BookApp.Registration.Exception.RegistrationException;



@RestControllerAdvice
public class RegistrationAdvice {
@ExceptionHandler(value = {RegistrationException.class})
	
	public ResponseEntity<String> Exception1(RegistrationException ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
