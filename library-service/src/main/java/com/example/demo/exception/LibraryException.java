package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.ui.ErrorResponseModel;

@RestControllerAdvice
public class LibraryException {
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleBookIdNotFoundException(BookNotFoundException e)
	{
		ErrorResponseModel model=new ErrorResponseModel();
		model.setErrorReportingTime(System.currentTimeMillis());
		model.setMessage(e.getMessage());
		model.setStatusCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);
	}

}
