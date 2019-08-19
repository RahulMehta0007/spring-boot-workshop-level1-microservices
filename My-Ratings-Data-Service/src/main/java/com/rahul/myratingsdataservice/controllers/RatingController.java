package com.rahul.myratingsdataservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.myratingsdataservice.model.Rating;
import com.rahul.myratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/getRatingData")
public class RatingController {

	/*
	 * @GetMapping("/{movieId}") public Rating getRating(@PathVariable String
	 * movieId) { return new Rating(movieId, 4); }
	 */

	@GetMapping("/{userId}")
	public UserRating getUserRating(@PathVariable String userId) {
		UserRating userRating = new UserRating();
		userRating.init(userId);

		return userRating;
	}

}
