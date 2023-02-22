package com.example.rating.service.services;

import java.util.List;

import com.example.rating.service.entities.Rating;

public interface RatingService {

	Rating create(Rating rating);
	List<Rating> get();
	List<Rating> getByUserId(String userId);
	List<Rating> getByHotelId(String hotelId);
}
