package com.example.rating.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rating.service.entities.Rating;
import com.example.rating.service.services.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	@Autowired
	private RatingService ratingService;
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating)
	{
		Rating rating2=ratingService.create(rating);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(rating2);
	}
	@GetMapping
	public ResponseEntity<List<Rating>> get()
	{
		List<Rating> ratings=ratingService.get();
		return ResponseEntity.ok(ratings);
	}
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getByUserId(@PathVariable String userId)
	{
		List<Rating> ratings=ratingService.getByUserId(userId);
		return ResponseEntity.ok(ratings);
	}
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String hotelId){
		List<Rating>ratings=ratingService.getByHotelId(hotelId);
		return ResponseEntity.ok(ratings);
	}
}
