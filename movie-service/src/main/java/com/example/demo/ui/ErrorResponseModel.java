package com.example.demo.ui;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponseModel {
	
	private String message;
	private Integer erorCode;
	private Long errorReportingTime;

}
