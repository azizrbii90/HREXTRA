package com.RHELP.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RHELP.entities.Presence;
import com.RHELP.entities.User;
import com.RHELP.repositories.PresenceRepo;
import com.RHELP.repositories.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PresenceController {

	@Autowired
	private PresenceRepo presenceRepo;

	@Autowired
	private UserRepo userRepo;

	@GetMapping("/presences/")
	public List<Presence> getAllpresences() {
		
		return presenceRepo.findAll();
	}

	@PostMapping("/presences/")
	public Presence createPresence(@RequestBody ObjectNode presence, @RequestParam Long id) throws JsonProcessingException {
		
		Presence pre = new Presence();
		pre.setNbrheures(new ObjectMapper().treeToValue(presence.get("nbrheures"), Integer.class));
		pre.setDay(LocalDate.parse(new ObjectMapper().treeToValue(presence.get("day"), String.class)));
		Optional<User> user = userRepo.findById(id);
		
		if (user.isPresent()) {
			pre.setUser(user.get());
		}
		
		return presenceRepo.save(pre);
	}
	
	@PutMapping("/presences")
	public Presence updatePresence(@RequestBody Presence presence) {
		return presenceRepo.save(presence);
	}
	
	@DeleteMapping("/presences/{id}")
	public void deletePresence (@PathVariable Long id){
		
		presenceRepo.deleteById(id);
	}
	
	@GetMapping("/presences/user/")
	public List<Presence> findUserPresenceByUserId (@RequestParam Long id) {
		
		return presenceRepo.findUserPresenceByUserId(id);
	}
}
