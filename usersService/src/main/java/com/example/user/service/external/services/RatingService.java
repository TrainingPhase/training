package com.example.user.service.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.user.service.entity.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	@GetMapping("/rating/users/{ratingId}")
	Rating[] getRating(@PathVariable String ratingId);
}
