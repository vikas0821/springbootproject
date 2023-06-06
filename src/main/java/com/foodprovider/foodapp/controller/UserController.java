package com.foodprovider.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodprovider.foodapp.config.ResponseStructure;
import com.foodprovider.foodapp.dto.User;
import com.foodprovider.foodapp.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	@PostMapping("/save")
	public User saveUser( @RequestBody User user) {
		return service.saveUser(user);
	}
	@GetMapping("/getusers")
	public List<User> getUser(){
		return service.getUser();
	}
	@DeleteMapping("/deletebyid")
	public ResponseStructure<User> deleteUser(@RequestParam int id) {
		return service.deletebyid(id);
	}
	@PutMapping("/update")
	public ResponseStructure<User> updateUser(@RequestParam int id,@RequestBody User user) {
		return service.updateUser(id, user);
	}
	@GetMapping("/getusersbyemail")
	public ResponseStructure<User> getUserByEmail(@RequestParam String email,@RequestParam String password){
		return service.getUserByEmail(email,password);
	}
}




