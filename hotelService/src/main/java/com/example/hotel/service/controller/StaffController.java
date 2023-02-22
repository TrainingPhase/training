package com.example.hotel.service.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController {
	@GetMapping
	public ResponseEntity<List<String>> staffList(){
		 
		return new ResponseEntity<List<String>>(Arrays.asList("Ram","Seetha","Krishna","Radha"),HttpStatus.FOUND);
	}

}
