package com.rahul.mymoviecinfoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.mymoviecinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {
	@GetMapping("/{movieId}")
	public Movie getMovie(@PathVariable String movieId)
	{
		return new Movie(movieId,"Transformers","Movie Description");
	}
	
	
}
