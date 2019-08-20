package com.rahul.myratingsdataservice.model;

import java.util.Arrays;
import java.util.List;

public class UserRating {

	private String userId;
	private List<Rating> ratingList;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Rating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}

	public void init(String userId) {
		this.setUserId(userId);
		this.setRatingList( Arrays.asList(new Rating("100", 100), new Rating("200", 80), new Rating("550", 90)));

	}
	
	
	

}
