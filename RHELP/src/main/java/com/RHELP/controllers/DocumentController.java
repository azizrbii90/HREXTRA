package com.RHELP.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.RHELP.entities.Document;
import com.RHELP.repositories.DocumentRepo;

@RestController
public class DocumentController {
	

	@Autowired
	private DocumentRepo documentRepo ;
	
	@GetMapping("/document/{id}")
	public List<Document> findDocumentByUserId(@PathVariable Long id ) {
		return documentRepo.findDocumentByUserId(id);
	}

	@GetMapping("/document/titre/{titre}")
	public List<Document> findDocumentByTitle(@PathVariable String titre){
		return documentRepo.findDocumentByTitle(titre);
	}
	
	@GetMapping("/document/type/{type}")
	public List<Document> findByDocumentType(@PathVariable String type){
		return documentRepo.findDocumentByType(type);
	}
	
}

