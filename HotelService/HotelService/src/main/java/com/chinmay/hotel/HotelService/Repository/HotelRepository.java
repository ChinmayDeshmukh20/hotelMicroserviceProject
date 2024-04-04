package com.chinmay.hotel.HotelService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chinmay.hotel.HotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel , String>{

}
