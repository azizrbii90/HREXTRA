package com.RHELP.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RHELP.entities.Caisse;
import com.RHELP.entities.User;
import com.RHELP.repositories.CaisseRepo;
import com.RHELP.repositories.UserRepo;

@RestController
public class CaisseController {

	@Autowired
	private CaisseRepo caisseRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	
	@GetMapping("/caisses")
	public List<Caisse> getAllCaisses() {
		
		return caisseRepo.findAll();
	}
	
	@PostMapping("/createCaisse") 
	public Caisse createCaisse(@RequestBody Caisse caisse, @RequestParam Long id) {
		
		User user = userRepo.findById(id).get();
		caisse.setUser(user);
		
		if(user != null) {
			user.setBudget(user.getBudget() + caisse.getMontant());
			userRepo.save(user);
		}
		
		return caisseRepo.save(caisse);
	}
	
	@DeleteMapping("/deleteCaisse/{id}")
	public ResponseEntity<Caisse> deleteExpense(@PathVariable("id") Long id) {
		
		Optional<Caisse> caisse = caisseRepo.findById(id);
		User user = caisse.get().getUser();
		
		if(user != null) {
			user.setBudget(user.getBudget() - caisse.get().getMontant());
			userRepo.save(user);
		}
		
		if(caisse.isPresent()) {
			caisseRepo.delete(caisse.get());
			return new ResponseEntity<Caisse>(caisse.get(),HttpStatus.ACCEPTED); 
		} else {
			return new ResponseEntity<Caisse>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	
	
	
	
	
	
}
