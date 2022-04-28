package com.RHELP.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RHELP.entities.Document;
import com.RHELP.repositories.DocumentRepo;

@Service
public class DocumentService {


	@Autowired
	private DocumentRepo docRepo;

	public List<Document> getAllDocuments(Document doc) {
		return docRepo.findAll();
	}
	
	public Document saveDocument (Document doc) {
		return docRepo.save(doc);
	}
	
}
