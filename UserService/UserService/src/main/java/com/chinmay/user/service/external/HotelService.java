package com.chinmay.user.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.chinmay.user.service.entities.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {

	
	@GetMapping("/hotels/{hotelId}")
	Hotel getHotel(@PathVariable String hotelId);
	
}
