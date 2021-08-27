package com.example.demo;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.MovieRepository;
import com.example.demo.model.Genre;
import com.example.demo.model.MovieEntity;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MovieServiceApplication implements CommandLineRunner {
	private MovieRepository movieRepository;

	@Autowired
	public MovieServiceApplication(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public Docket myDocket()
	{
		return new Docket(DocumentationType.SWAGGER_2);
	}

	@Override
	public void run(String... args) throws Exception {
		movieRepository.save(new MovieEntity(1,UUID.randomUUID().toString(),"Movie-A",Genre.COMEDY,true));
		movieRepository.save(new MovieEntity(2,UUID.randomUUID().toString(),"Movie-B",Genre.HORROR,false));
		movieRepository.save(new MovieEntity(3,UUID.randomUUID().toString(),"Movie-C",Genre.ROMANTIC,true));
		movieRepository.save(new MovieEntity(4,UUID.randomUUID().toString(),"Movie-D",Genre.COMEDY,false));
		movieRepository.save(new MovieEntity(5,UUID.randomUUID().toString(),"Movie-E",Genre.COMEDY,true));
		movieRepository.save(new MovieEntity(6,UUID.randomUUID().toString(),"Movie-F",Genre.COMEDY,true));

	}

}
