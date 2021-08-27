package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MovieDto;
import com.example.demo.exception.MovieNotFoundException;

public interface MovieService {

	public MovieDto createMovie(MovieDto movieDto);

	public List<MovieDto> displayAllMovies();

	public MovieDto getMovieByMovieId(String id) throws MovieNotFoundException;

	public MovieDto updateMovieByMovieId(String movieId, MovieDto movieRequestEntity) throws MovieNotFoundException;
	public void deleteMovieByMivieId(String movieId)throws MovieNotFoundException;
}
