package com.RHELP.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RHELP.entities.NoteInterne;
import com.RHELP.repositories.NoteInterneRepo;

@RestController
public class NoteInterneController {

	@Autowired
	private NoteInterneRepo noteInterneRepo;
	
	@GetMapping("/notes/")
    public List<NoteInterne> getAllNotes() {
        
		return noteInterneRepo.findAll();
    }
	
	@PostMapping("/notes/")
    public NoteInterne createNoteInterne(@RequestBody NoteInterne noteInterne) {

		return noteInterneRepo.save(noteInterne);
	}
	
	@DeleteMapping("/notes/{id}")
	void deleteNote(@PathVariable Long id) {
		
		noteInterneRepo.deleteById(id);
	}
	
	@PutMapping("/notes/")
	public NoteInterne editNote(@RequestBody NoteInterne note) {
		
		return noteInterneRepo.save(note);
	}
}
