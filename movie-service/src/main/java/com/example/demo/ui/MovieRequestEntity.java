package com.example.demo.ui;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.example.demo.model.Genre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MovieRequestEntity {
	@NotNull
	@Length(min = 3 ,max = 10,message = "length of the movie must be between 3-10")
	private String movieName;
	private Genre genre;
	private Boolean isAvailable;

}
