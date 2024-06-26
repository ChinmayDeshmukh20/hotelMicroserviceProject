package com.chinmay.user.service.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinmay.user.service.entities.User;
import com.chinmay.user.service.services.UserService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	 Logger logger = LoggerFactory.getLogger(UserController.class);

	
	//create new User
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	
	}
	
	//get single user
	@GetMapping("/{userId}")
	//@CircuitBreaker(name="ratingHotelBreaker" ,fallbackMethod="ratingHotelFallback")
	@RateLimiter(name = "userRateLimiter" , fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId)
	{
		
		User user  =userService.getUser(userId);
		return ResponseEntity.ok(user);
	}

	// creating fallback method for circuitbreaker
	
	public ResponseEntity<User> ratingHotelFallback(String userId , Exception ex){
		logger.info("Fallback is executed as service is down :" , ex.getMessage());
		User user  =User.builder().email("dummy@gmail.com")
		.name("Dummy")
		.about("This user is dummy using fallback")
		.userId("123433")
		.build();
		return new ResponseEntity<>(user , HttpStatus.OK);
		
	}
	
	
	//get list of users
	@GetMapping
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	
	
}
