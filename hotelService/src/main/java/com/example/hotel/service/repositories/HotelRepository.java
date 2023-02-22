package com.example.hotel.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel.service.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
