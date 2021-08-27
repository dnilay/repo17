package com.example.demo.controller;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MovieDto;
import com.example.demo.service.MovieService;
import com.example.demo.ui.MovieRequestEntity;
import com.example.demo.ui.MovieResponseEntity;

@RestController
public class MovieController {

	private Environment environment;
	private MovieService movieService;
	private ModelMapper modelMapper;

	public MovieController(Environment environment, MovieService movieService, ModelMapper modelMapper) {
		super();
		this.environment = environment;
		this.movieService = movieService;
		this.modelMapper = modelMapper;
	}

	@RequestMapping
	public ResponseEntity<String> getStatus() {
		return ResponseEntity.ok("application up and listining on port" + environment.getProperty("local.server.port"));
	}

	@PostMapping("/movies")
	public ResponseEntity<MovieResponseEntity> createMovie(@Validated @RequestBody MovieRequestEntity movieDetails) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		MovieDto movieDto = modelMapper.map(movieDetails, MovieDto.class);
		movieDto.setMovieId(UUID.randomUUID().toString());
		MovieDto tempDto = movieService.createMovie(movieDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(tempDto, MovieResponseEntity.class));

	}

}
