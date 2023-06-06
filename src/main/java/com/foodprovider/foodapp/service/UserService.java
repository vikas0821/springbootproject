package com.foodprovider.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.foodprovider.foodapp.config.ResponseStructure;
import com.foodprovider.foodapp.dao.UserDao;
import com.foodprovider.foodapp.dto.User;

@Service
public class UserService {
	
		@Autowired	
		private UserDao dao;
		
		public User saveUser(User user) {
			return dao.saveUser(user);
		}
		
		public List<User> getUser(){
			return dao.getUser();
		}

	
		public ResponseStructure<User> updateUser(int id,User user){
			ResponseStructure<User> responseStructure=new ResponseStructure<User>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated successfully!!");
			responseStructure.setData(dao.updateUser(id,user));
			return responseStructure;
			
		}
		public ResponseStructure<User> deletebyid(int id){
			ResponseStructure<User> responseStructure=new ResponseStructure<User>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted successfully!!");
			responseStructure.setData(dao.deleteUser(id));
			return responseStructure;
			
		}
		
		public ResponseStructure<User> getUserByEmail(String email,String password){
			
			User user=dao.getUserByEmail(email);
			if(email.equals(user.getUseremail())&&password.equals(user.getUserpassword())) {
			ResponseStructure<User> responseStructure=new ResponseStructure<User>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("login successfully!!");
			responseStructure.setData(dao.getUserByEmail(email));
			return responseStructure;
			}
			return null;
		}
		
		
		
	
}
