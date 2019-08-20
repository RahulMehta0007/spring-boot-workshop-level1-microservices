package com.rahul.mymoviecinfoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rahul.mymoviecinfoservice.model.Movie;
import com.rahul.mymoviecinfoservice.model.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Value("${api-key}")
	private String apiKey;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{movieId}")
	public Movie getMovie(@PathVariable String movieId)
	{	System.out.println("API KEY "+apiKey);
		String movieDbURL="https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey;
		System.out.println("URL IS "+movieDbURL);
		MovieSummary movieSummary=restTemplate.getForObject(movieDbURL,MovieSummary.class);
		System.out.println("Movie SUmmary : "+movieSummary);
		return new Movie(movieId,movieSummary.getTitle(),movieSummary.getOverview());
	}
	
	
}
