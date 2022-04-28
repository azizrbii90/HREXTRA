package com.RHELP.controllers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RHELP.repositories.UserRepo;
import com.RHELP.services.UserService;
import com.RHELP.entities.User;

@RestController
public class UserController {

	@Autowired
	ServletContext context;
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List <User> getAllUsers() {
		
		return userRepo.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findById(@PathVariable("id") Long id) {
		
		return userRepo.findById(id).get();
	}
	
	@GetMapping("users/avatar/{id}")
	public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
		
		User user = userRepo.findById(id).get();
		return Files.readAllBytes(Paths.get(context.getRealPath("/Images/") + user.getPhoto()));
	}
	
	@GetMapping("/users/budget/{id}")
	public int getBudget(@PathVariable("id") Long id) {
		
		User user = userRepo.findById(id).get();
		return user.getBudget();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userRepo.deleteById(id);
	}
	
	@PutMapping("/users/")
	public User updateUser(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	
	
	
	
	
	
	
}
