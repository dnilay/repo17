package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MovieNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -7429154151533035897L;
	
	private String message;
	

}
