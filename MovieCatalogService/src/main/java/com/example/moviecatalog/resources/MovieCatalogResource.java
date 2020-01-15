package com.example.moviecatalog.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.moviecatalog.entity.CatalogItem;
import com.example.moviecatalog.entity.Movie;
import com.example.moviecatalog.entity.Rating;

@RestController
@RequestMapping(value = "/catalog")
public class MovieCatalogResource {

	private RestTemplate restTemplate;

	@GetMapping(value = "/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		List<Rating> ratings = Arrays.asList(new Rating("Bahubali", 5), new Rating("Bahubali-2", 5));

		
		Movie movie = null;

		for (Rating rating : ratings) {
			movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
			if (null != movie) {
				return Collections.singletonList(
						new CatalogItem(movie.getMovieName(), "Legand of South India", rating.getRating()));
			}
		}
		return null;

	}

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}
