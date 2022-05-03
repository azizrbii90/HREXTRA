package com.RHELP.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.RHELP.repositories.UserRepo;
import com.RHELP.services.FileUploadService;
import com.RHELP.services.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.RHELP.entities.User;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	ServletContext context;
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
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
	
	@PostMapping("/update-password")
	public String principalchangepassword(@RequestParam String oldPassword,@RequestParam String newPassword,@RequestParam String confirmPassword){
	    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		User user = userRepo.findByUsername(username).get();
		String password = user.getPassword();
		boolean x = passwordEncoder.matches(oldPassword, password);
		if(x) {
			user.setPassword(passwordEncoder.encode(newPassword));
			userRepo.save(user);
		    return "Password Updated successfully";

		}
	    return "Password Not updated";
	}
	
	@PutMapping("/users/")
	public User updateUser(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@PostMapping(value="/update-avatar")
	public ResponseEntity<?> updateAvatar(@RequestParam("idUser") Long idUser, @RequestParam("avatar")
	MultipartFile file) throws JsonParseException, JsonMappingException, IOException {

		User user1 = userRepo.findById(idUser).get();
		
		
		user1.setPhoto(fileUploadService.upload(file));
		
		User user2 = userRepo.save(user1);
		
		if(user2!=null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(user2);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user not updated");
		}
	}
	
	
	
}
