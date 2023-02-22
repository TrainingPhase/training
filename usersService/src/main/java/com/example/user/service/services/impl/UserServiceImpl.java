package com.example.user.service.services.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user.service.entity.Hotel;
import com.example.user.service.entity.Rating;
import com.example.user.service.entity.User;
import com.example.user.service.exceptions.ResourceNotFoundException;
import com.example.user.service.external.services.HotelSevice;
import com.example.user.service.external.services.RatingService;
import com.example.user.service.repository.UserRepository;
import com.example.user.service.services.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelSevice hotelSevice;
	
	@Autowired
	private RatingService ratingService;
	@Override
	public User saveUser(User user) {
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll().stream().map(user->{
			Rating[]ratings=restTemplate.getForObject("http://RATING-SERVICE/rating/users/"+user.getUserId(), Rating[].class);	
			List<Rating> ratingslist=Arrays.stream(ratings).toList();
			 List<Rating> rates=ratingslist.stream().map(rating->
			 {
				 Hotel hotel=restTemplate.getForObject("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(),Hotel.class);
				 rating.setHotel(hotel);
				 return rating;
			 }).collect(Collectors.toList());
			 user.setRatings(rates);
			return user;}	).collect(Collectors.toList());
	
		
	}

	@Override
	public User getUser(String userId) {

	  User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found on server::"+userId));
	  
	  //http://localhost:8082/rating/users/71531643-af18-403e-8fb3-0d9675470671
	 Rating[] object= ratingService.getRating(user.getUserId());
	 List<Rating>ratings=Arrays.stream(object).toList();
	 List<Rating> rates=ratings.stream().map(rating->
	 {
		 Hotel hotel=hotelSevice.gethotel(rating.getHotelId());
		 rating.setHotel(hotel);
		 return rating;
	 }).collect(Collectors.toList());
	 user.setRatings(rates);
	  return user;
	}
}
