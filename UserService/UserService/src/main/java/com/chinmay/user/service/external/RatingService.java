package com.chinmay.user.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.chinmay.user.service.entities.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

	
	//to create ratings
	@PostMapping("/ratings")
	Rating createRating(Rating values);
	
	
	//only createRating will work as for below 2 methods we havent created api methods in Controllers
	
	//to update ratings
	@PutMapping("/ratings/{ratingId}")
	Rating updateRating(@PathVariable String ratingId , Rating rating);
	
	@DeleteMapping("/ratings/{ratingId}")
	void deleteRating(@PathVariable String ratingId);
	
}
