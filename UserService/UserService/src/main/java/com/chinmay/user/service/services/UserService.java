package com.chinmay.user.service.services;

import java.util.List;

import com.chinmay.user.service.entities.User;

public interface UserService {


	//create user
	User saveUser(User user);

	//get all user
	List<User> getAllUser();

	//get Single user of given UserId
	User getUser(String userId);


	//TODO : delete , update

}
