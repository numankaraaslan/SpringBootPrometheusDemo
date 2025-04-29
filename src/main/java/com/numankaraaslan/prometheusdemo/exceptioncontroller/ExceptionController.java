package com.numankaraaslan.prometheusdemo.exceptioncontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController
{
	@ExceptionHandler
	public ResponseEntity<String> exceptionhandler(Exception ex)
	{
		return ResponseEntity.internalServerError().body(ex.getMessage());
	}
}
