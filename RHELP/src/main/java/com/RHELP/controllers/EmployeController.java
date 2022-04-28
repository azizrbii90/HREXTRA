package com.RHELP.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RHELP.entities.Conge;
import com.RHELP.entities.Employe;
import com.RHELP.repositories.EmployeRepo;
import com.RHELP.services.EmployeService;

@RestController
@RequestMapping
public class EmployeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EmployeRepo employeRepo;
	
	@Autowired
	private EmployeService employeService;
	
	@Autowired
	ServletContext context;
	
	@GetMapping("/employees/")
    public List<Employe> getAllEmployees() {
        
		return employeService.getAllEmployees();
    }
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employe> findById(@PathVariable("id") Long id) {
		
		Optional<Employe> emp = employeService.findById(id);
		if (emp.isPresent())
			return new ResponseEntity<Employe>(emp.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Employe>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/employees/")
	public ResponseEntity<Employe> create(@RequestBody Employe employe) {
		
		try {
			employeService.saveEmploye(employe);
			return new ResponseEntity<Employe>(employe, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Employe>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employe> deleteEmploye(@PathVariable("id") Long id) {
		
		Optional<Employe> emp = employeService.findById(id);
		if (emp.isPresent()) {
			employeService.deleteEmploye(emp.get());
			return new ResponseEntity<Employe>(emp.get(), HttpStatus.ACCEPTED);
		} else
			return new ResponseEntity<Employe>(HttpStatus.NOT_ACCEPTABLE);
	}
		
	@GetMapping("/employees/count")
	Long countEmploye() {
		
		return employeService.countEmploye();
	}
	
	@GetMapping("/employees/conges")
	public List<Conge> getCongeByemployeId (Long id) {
		
		return employeService.getCongeByemployeId(id);
	}	
}
