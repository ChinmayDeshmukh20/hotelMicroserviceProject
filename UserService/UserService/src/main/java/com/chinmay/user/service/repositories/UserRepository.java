package com.chinmay.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chinmay.user.service.entities.User;

public interface UserRepository extends JpaRepository<User , String> {


	//if we want to implement any custom method or query we can write here


}
