package com.RHELP.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RHELP.dto.RegisterRequest;
import com.RHELP.repositories.UserRepo;
import com.RHELP.entities.User;


@Service
public class AuthService {

	@Autowired
	private UserRepo userRepo;
	
	public void signup (RegisterRequest registerRequest) {
		User user = new User();
		user.setUsername(registerRequest.getUsername());
		user.setPassword(registerRequest.getPassword());
		user.setEmail(registerRequest.getEmail());
		userRepo.save(user);
	}
}
