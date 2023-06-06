package com.foodprovider.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodprovider.foodapp.dto.User;
import com.foodprovider.foodapp.repo.UserRepo;

@Repository
public class UserDao {
	@Autowired
	private UserRepo repo;
	public User saveUser(User user) {
		return repo.save(user);
	}
	public List<User> getUser(){
		return repo.findAll();
	}
	public User deleteUser(int id) {
		Optional<User> u1=repo.findById(id);
		if(u1!=null) {
			repo.deleteById(id);
			return u1.get();
		}
		return null;
	}
//	
	public User updateUser(int id, User user) {
		Optional<User> option=repo.findById(id);
		if(!option.isEmpty()) {
			user.setUserId(id);
			return repo.save(user);
		}
		return null;
	}
	public User getUserByEmail(String email) {
		User u1=repo.getUserByEmail(email);
		if(u1!=null) {
		
			return repo.getUserByEmail(email);
		}
		return null;
	}
	
//	public User getUserByEmail(String email) {
//		
//		return repo.getUserByEmail(email);
//		
//	}
	
}

