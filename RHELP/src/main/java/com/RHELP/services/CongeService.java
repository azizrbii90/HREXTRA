package com.RHELP.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RHELP.repositories.CongeRepo;
import com.RHELP.repositories.UserRepo;
import com.RHELP.entities.Conge;
import com.RHELP.entities.User;

@Service
public class CongeService {

	private int d=0;
	
	@Autowired
	private CongeRepo congeRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	
	public List<Conge> getAllConges() {
		
		return congeRepo.findAll();
	}
	
	public Optional<Conge> findCongeById(Long id) {
		
		return congeRepo.findById(id);
	}
	
	public Conge createConge(Conge conge) {
		
		conge.setStatusOfRequest("not_yet_treated");
		return congeRepo.save(conge);
	}
	
	public Conge updateConge(Conge conge) {
		
		return congeRepo.save(conge);
	}
	
	public void deleteConge(Conge conge) {
		
		congeRepo.delete(conge);
	}
	
	public void accepterConge(Long id) {
		
		Conge conge = congeRepo.findById(id).get();
		conge.setStatusOfRequest("accepted");
		congeRepo.save(conge);
		
		User user = conge.getUser();
		user.setJoursConges(user.getJoursConges() + conge.getDuree());
		user.setSoldeConges(user.getDureeConges() - user.getJoursConges());
		userRepo.save(user);
	}
	
	
	public void refuserConge(Long id) {
		
		Conge conge = congeRepo.findById(id).get();
		conge.setStatusOfRequest("refused");
		congeRepo.save(conge);
	}
	
	public int countDuree(Long id) {
		
		User user = userRepo.findById(id).get();
		List<Conge> conges = user.getConges();
		
		for(Conge conge : conges) {
			d += conge.getDuree();
		}
		
		return d;
	}
	
	
	public void updateDuree(Long id) {
		
		User user = userRepo.findById(id).get();
		user.setDureeConges(d);
		userRepo.save(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
