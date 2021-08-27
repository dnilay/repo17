package com.example.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class MovieEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "movie_id",nullable = false,unique = true)
	private String movieId;
	@Column(name = "movie_name",nullable = false,unique = true)
	private String movieName;
	@Column(name = "genre_type",nullable = true,unique = false)
	@Enumerated(EnumType.STRING)
	private Genre genre;
	@Column(name = "is_available",nullable = false,unique = false)
	@JsonProperty
	private Boolean isAvailable;

}
