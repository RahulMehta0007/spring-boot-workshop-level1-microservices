package com.rahul.mymoviecatalogservice.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rahul.mymoviecatalogservice.models.CatalogItem;
import com.rahul.mymoviecatalogservice.models.Movie;
import com.rahul.mymoviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId)
	{
	String movieRatingURL="http://ratings-data-service/getRatingData/"+userId;		
		
	UserRating userRating=restTemplate.getForObject(movieRatingURL,UserRating.class);
	
	return userRating.getRatingList().stream().map(
			 rating->
			{
			Movie movie=restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(),Movie.class);
			return new CatalogItem(movie.getName(),movie.getDescription(), rating.getRating());
			
			}
			
			).collect(Collectors.toList());
	
	
	}
	

}
