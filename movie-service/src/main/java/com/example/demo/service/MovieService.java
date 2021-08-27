package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MovieDto;

public interface MovieService {

	public MovieDto createMovie(MovieDto movieDto);
	public List<MovieDto> displayAllMovies();
}
