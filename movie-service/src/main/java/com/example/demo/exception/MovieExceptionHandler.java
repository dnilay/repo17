package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.ui.ErrorResponseModel;

@RestControllerAdvice
public class MovieExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleMovieNotFoundException(MovieNotFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponseModel.builder().message(e.getMessage()).erorCode(HttpStatus.NOT_FOUND.value())
				.errorReportingTime(System.currentTimeMillis()).build());
	}
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleGlobalException(Exception e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponseModel.builder().message(e.getMessage()).erorCode(HttpStatus.NOT_FOUND.value())
				.errorReportingTime(System.currentTimeMillis()).build());
	}

}
