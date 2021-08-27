package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MovieRepository;
import com.example.demo.dto.MovieDto;
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
		MovieEntity theMovie=modelMapper.map(movieDto, MovieEntity.class);
		movieRepository.save(theMovie);
		MovieDto dto=modelMapper.map(theMovie, MovieDto.class);
		return dto;
	}

}
