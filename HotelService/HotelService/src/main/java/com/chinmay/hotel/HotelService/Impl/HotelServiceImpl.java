package com.chinmay.hotel.HotelService.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinmay.hotel.HotelService.Repository.HotelRepository;
import com.chinmay.hotel.HotelService.entities.Hotel;
import com.chinmay.hotel.HotelService.exceptions.ResourceNotFoundException;
import com.chinmay.hotel.HotelService.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel create(Hotel hotel) {
		
	String hotelId = UUID.randomUUID().toString();	
	hotel.setId(hotelId);
	return 	hotelRepository.save(hotel);
	
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found"));
	}
	

}
