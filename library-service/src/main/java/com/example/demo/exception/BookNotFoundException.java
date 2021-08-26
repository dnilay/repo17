package com.example.demo.exception;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1260315064685284145L;
	private String message;
	public BookNotFoundException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	

}
