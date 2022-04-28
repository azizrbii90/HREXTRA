package com.RHELP.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RHELP.entities.Todo;
import com.RHELP.repositories.TodoRepo;

@RestController
public class TodoController {
	
	@Autowired
	private TodoRepo todoRepo;
	
	@GetMapping("/todos")
	public List<Todo> getAllTodos() {
		
		return todoRepo.findAll();
	}
	
	@GetMapping("/todos/{id}")
	public Todo getTodo(@PathVariable Long id) {
		
		return todoRepo.findById(id).get();
	}
	
	@PostMapping("/todos")
	public Todo createTodo(@RequestBody Todo todo) {
		
		todo.setCompleted(false);
		return todoRepo.save(todo);
	}
	
	@PutMapping("/todos")
	public Todo modifyTodo(@RequestBody Todo todo) {
		
		return todoRepo.save(todo);
	}
	
	@DeleteMapping("/todos/{id}")
	public void deleteTodo(@PathVariable Long id) {
		
		todoRepo.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	

}
