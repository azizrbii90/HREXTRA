package com.RHELP.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RHELP.entities.Conge;
import com.RHELP.entities.Employe;
import com.RHELP.repositories.EmployeRepo;

@Service
public class EmployeService {

	@Autowired
	private EmployeRepo employeRepo;

	
	public List<Employe> getAllEmployees() {
		
		return employeRepo.findAll();
	}

	
	public boolean saveEmploye(Employe employe) {

		if (employeRepo.save(employe) != null)
			return true;
		else
			return false;
	}

	
	public void deleteEmploye(Employe employe) {
		
		if (employe != null)
			employeRepo.delete(employe);
	}

	
	public Employe updateEmploye(Employe employe) {
		
		return employeRepo.save(employe);
	}

	
	public Long countEmploye() {

		return employeRepo.count();
	}

	
	public Optional<Employe> findById(Long id) {
		
		return employeRepo.findById(id);
	}
	
	public List<Conge> getCongeByemployeId (Long id){
		
		Employe employe = employeRepo.getById(id);
		if (employe.getConges() != null)
			return employe.getConges();
		else 
			return null ;
	}
	
}
