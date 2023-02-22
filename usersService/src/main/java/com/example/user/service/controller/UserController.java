package com.example.user.service.controller;

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

import com.example.user.service.entity.User;
import com.example.user.service.services.UserService;
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user2=userService.saveUser(user);
		return new ResponseEntity<User>(user2,HttpStatus.CREATED);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUsers(@PathVariable String userId)
	{
		User user=userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User>allUsers=userService.getAllUser();
		return ResponseEntity.ok(allUsers);
	}
}
