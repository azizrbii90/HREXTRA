package com.RHELP.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.RHELP.entities.User;
import com.RHELP.repositories.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public boolean updateUsername(String email, String username) {
		Optional <User> opt = this.userRepo.findByEmail(email);
		User user;
		if(opt.isPresent()) {
			user = opt.get();
			user.setUsername(username);
			this.userRepo.save(user);
			return true;
		}
		return false;
	}
	
	public boolean updatePassword(String email, String oldPass, String newPass) {
		Optional<User> opt = this.userRepo.findByEmail(email);
		User user;
		if(opt.isPresent()) {
			user =  opt.get();
			
			if(passwordEncoder.matches(oldPass, user.getPassword())) {
				user.setPassword(passwordEncoder.encode(newPass));
				 this.userRepo.save(user);
				 return true;
			}
		
		}
		return false;
	}
}
