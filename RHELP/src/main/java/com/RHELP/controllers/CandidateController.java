package com.RHELP.controllers;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.RHELP.repositories.CandidatRepo;
import com.RHELP.services.CandidateService;
import com.RHELP.services.FileUploadService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.RHELP.entities.Candidat;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CandidateController {
	
	@Autowired
	private CandidatRepo candidatRepo;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	private static final Logger logger = LoggerFactory.getLogger(CandidateController.class);
	
	@Autowired
	private CandidateService candidatService;
	
	@GetMapping("/create")
	public List<Candidat> getAllCandidates() {
		
		return candidatRepo.findAll();
	}
	
	@PostMapping("/candidats")
	public Candidat createCandidat(@RequestBody Candidat candidat) {
		
		return candidatRepo.save(candidat);
	}
	
	private final Path rootLocation = Paths.get("C:\\Utilisateurs\\Aziz\\Bureau\\candidats");	

	@PostMapping(value="/create-candidat")
	public ResponseEntity<?> createCandidate(@RequestParam("candidate") String candidate, @RequestParam("cv_file")
	MultipartFile file1, @RequestParam("motiv_letter_file") MultipartFile file2) throws JsonParseException, JsonMappingException, IOException {

		Candidat candidate1 = new ObjectMapper().readValue(candidate, Candidat.class);
		System.out.println("the candidate" + candidate1);
		
		candidate1.setPathCv(fileUploadService.upload(file1));
		candidate1.setPathMotivationLetter(fileUploadService.upload(file2));
		
		Candidat candidate2 = candidatRepo.save(candidate1);
		
		if(candidate2!=null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("candiate is saved");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("candidate is not saved");
		}
	}
	
	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws Exception {
		
		Resource resource = candidatService.loadFileResource(fileName);
		
		String contentType = null;
		
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		}
		 catch (IOException e) {
			 logger.info("could not determine file type");
		 }
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
	
	@GetMapping("/candidats/{id}")
	public ResponseEntity<Candidat> findById(@PathVariable("id") Long id) {
		
		Optional<Candidat> c = candidatRepo.findById(id);
		if (c.isPresent())
			return new ResponseEntity<Candidat>(c.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Candidat>(HttpStatus.NO_CONTENT);

	}
	
	@DeleteMapping("/candidate/{id}")
	void deleteNote(@PathVariable Long id) {
	
		candidatRepo.deleteById(id);
	}

}
