package com.chinmay.rating.RatingService.services;

import java.util.List;

import com.chinmay.rating.RatingService.entities.Rating;

public interface RatingService {

	//create
	Rating create(Rating rating);
	
	//get all ratings
	List<Rating> getRatings();
	
	//get all by UserId
	List<Rating> getRatingByUserId(String userId);
	
	//get all ratings by hotelId
	List<Rating> getRatingByHotelId(String hotelId);
	
	
	
	
	
	
	
}
