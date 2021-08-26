package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.demo.ui.ErrorResponseModel;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class LibraryException {
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleBookIdNotFoundException(BookNotFoundException e) {
		log.info("BookNotFoundException");
		ErrorResponseModel model = new ErrorResponseModel();
		model.setErrorReportingTime(System.currentTimeMillis());
		model.setMessage(e.getMessage());
		model.setStatusCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleNumberFormatException(MethodArgumentTypeMismatchException e) {
		log.info("MethodArgumentTypeMismatchException");
		ErrorResponseModel model = new ErrorResponseModel();
		model.setErrorReportingTime(System.currentTimeMillis());
		model.setMessage("argument type mismatched required Integer");
		model.setStatusCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleGlobalException(Exception e) {
		log.info("Exception");
		ErrorResponseModel model = new ErrorResponseModel();
		model.setErrorReportingTime(System.currentTimeMillis());
		model.setMessage(e.getMessage());
		model.setStatusCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);
	}
}
