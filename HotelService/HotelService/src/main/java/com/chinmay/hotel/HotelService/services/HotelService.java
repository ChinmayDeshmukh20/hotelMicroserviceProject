package com.chinmay.hotel.HotelService.services;

import java.util.List;

import com.chinmay.hotel.HotelService.entities.Hotel;

public interface HotelService {

	//create Hotel
	Hotel create(Hotel hotel);
	
	//getall hotels
	List<Hotel> getAll();
	
	//get single hotel
	Hotel get(String id);
	
}
