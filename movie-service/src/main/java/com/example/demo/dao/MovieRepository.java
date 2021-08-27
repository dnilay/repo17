package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MovieEntity;
@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

	@Query
	public MovieEntity findByMovieId(String movieId);
}
