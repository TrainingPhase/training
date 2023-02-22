package com.example.hotel.service.controller;

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

import com.example.hotel.service.entities.Hotel;
import com.example.hotel.service.services.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	@PostMapping
	public ResponseEntity<Hotel> create(@RequestBody Hotel hotel)
	{
		Hotel hotel2=hotelService.create(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel2);
	}
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll(){
		List<Hotel>hotels=hotelService.getAll();
		return ResponseEntity.ok(hotels);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> get(@PathVariable String id){
		Hotel hotel=hotelService.get(id);
		return ResponseEntity.ok(hotel);
	}
}
