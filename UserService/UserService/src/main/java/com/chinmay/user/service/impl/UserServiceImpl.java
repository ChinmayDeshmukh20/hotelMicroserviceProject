package com.chinmay.user.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chinmay.user.service.entities.Hotel;
import com.chinmay.user.service.entities.Rating;
import com.chinmay.user.service.entities.User;
import com.chinmay.user.service.exceptions.ResourceNotFoundException;
import com.chinmay.user.service.external.HotelService;
import com.chinmay.user.service.repositories.UserRepository;
import com.chinmay.user.service.services.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;


	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	@Override
	public User saveUser(User user) {
		//unique userid will be generated for each user
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id not found" + userId) );
		
		//fetch rating of above user from RATING SERVICE
		Rating[] ratingsOfUser  = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+ user.getUserId() , Rating[].class);
		logger.info("{}" , ratingsOfUser);

		List<Rating> ratings =  Arrays.stream(ratingsOfUser).toList();
		
		
		List<Rating> ratingList= ratings.stream().map(rating-> {
		
			//http://localhost:8082/hotels/1fe89f57-c7bc-4e27-9fd9-6a3b40495b29
			
			//ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			//logger.info("Response status code: ",forEntity.getStatusCode());
			rating.setHotel(hotel);
			
			return rating;
			
		}).collect(Collectors.toList());
		
		
		user.setRatings(ratingList);
		return user;
	}

}
