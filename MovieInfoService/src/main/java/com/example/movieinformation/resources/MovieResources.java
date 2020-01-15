package com.example.movieinformation.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieinformation.entity.Movie;

@RestController
@RequestMapping(value = "/movies")
public class MovieResources {

	@GetMapping(value = "/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		return new Movie("Bahubali", movieId);
	}

}
