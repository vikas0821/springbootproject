package com.foodprovider.foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodprovider.foodapp.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	@Query("Select u from User u where u.useremail=?1")
	public User getUserByEmail(String email);
}
