package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MovieDto;
import com.example.demo.exception.MovieNotFoundException;
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

	@GetMapping(value = "/movies", produces = { "application/json" })
	public ResponseEntity<List<MovieResponseEntity>> displayAllMovies() {
		List<MovieDto> list = movieService.displayAllMovies();
		List<MovieResponseEntity> responses = new ArrayList<MovieResponseEntity>();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		for (MovieDto dto : list) {
			responses.add(modelMapper.map(dto, MovieResponseEntity.class));
		}

		return new ResponseEntity<List<MovieResponseEntity>>(responses, HttpStatus.OK);
	}

	@GetMapping("/movies/{movieId}")
	public ResponseEntity<MovieResponseEntity> findMovieByMovieId(@PathVariable("movieId") String movieId) throws MovieNotFoundException {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		MovieDto dto = movieService.getMovieByMovieId(movieId);
		return ResponseEntity.ok(modelMapper.map(dto, MovieResponseEntity.class));

	}
	
	@PutMapping("/movies/{movieId}")
	public ResponseEntity<MovieResponseEntity> updateMovieByMovieId(@PathVariable("movieId") String movieid,@RequestBody MovieRequestEntity movieRequestEntity)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		MovieDto dto=movieService.updateMovieByMovieId(movieid, modelMapper.map(movieRequestEntity, MovieDto.class));
		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(dto, MovieResponseEntity.class));
	}
	
	@DeleteMapping("/movies/{movieId}")
	public ResponseEntity<String> deleteMovieByMovieId(@PathVariable("movieId") String movieId)
	{
		movieService.deleteMovieByMivieId(movieId);
		return ResponseEntity.status(HttpStatus.OK).body("deletion sucessfull");
	}
	

}
