package com.example.demo.ui;

import com.example.demo.model.Genre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MovieResponseEntity {

	private String movieId;
	private String movieName;
	private Genre genre;
	private Boolean isAvailable;

}
