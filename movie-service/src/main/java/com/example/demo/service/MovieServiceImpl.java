package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MovieRepository;
import com.example.demo.dto.MovieDto;
import com.example.demo.exception.MovieNotFoundException;
import com.example.demo.model.MovieEntity;

@Service
public class MovieServiceImpl implements MovieService {
	private MovieRepository movieRepository;
	private ModelMapper modelMapper;

	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository, ModelMapper modelMapper) {
		this.movieRepository = movieRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public MovieDto createMovie(MovieDto movieDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		MovieEntity theMovie = modelMapper.map(movieDto, MovieEntity.class);
		movieRepository.save(theMovie);
		MovieDto dto = modelMapper.map(theMovie, MovieDto.class);
		return dto;
	}

	@Override
	public List<MovieDto> displayAllMovies() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<MovieDto> dtos = new ArrayList<MovieDto>();
		List<MovieEntity> movies = movieRepository.findAll();
		Iterator<MovieEntity> iterator = movies.iterator();
		while (iterator.hasNext()) {
			dtos.add(modelMapper.map(iterator.next(), MovieDto.class));
		}
		return dtos;
	}

	@Override
	public MovieDto getMovieByMovieId(String id) throws MovieNotFoundException {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		MovieEntity entity = movieRepository.findByMovieId(id);
		if (entity == null) {
			throw new MovieNotFoundException("movie with the given id not found");
		}
		return modelMapper.map(entity, MovieDto.class);
	}

	@Override
	public MovieDto updateMovieByMovieId(String movieId, MovieDto movieRequestEntity) throws MovieNotFoundException {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		MovieEntity entity = movieRepository.findByMovieId(movieId);
		if (entity == null) {
			throw new MovieNotFoundException("movie with the given id not found");
		}
		entity.setIsAvailable(movieRequestEntity.getIsAvailable());
		entity.setGenre(movieRequestEntity.getGenre());
		entity.setMovieName(movieRequestEntity.getMovieName());
		movieRepository.save(entity);
		return modelMapper.map(entity, MovieDto.class);
	}

	@Override
	public void deleteMovieByMivieId(String movieId) throws MovieNotFoundException {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		MovieEntity entity = movieRepository.findByMovieId(movieId);
		if (entity == null) {
			throw new MovieNotFoundException("movie with the given id not found");
		}
		movieRepository.delete(entity);
		
		
	}

}
