package com.RHELP.services;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.core.io.AbstractFileResolvingResource;

@Service
public class CandidateService {

	
	public final Path fileStorageLocation = Paths.get("C:\\Utilisateurs\\Aziz\\Bureau\\candidats");
	
	public Resource loadFileResource(String fileName) throws Exception {
		
		try {
			
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = (Resource) new UrlResource(filePath.toUri());
			
			if(((AbstractFileResolvingResource) resource).exists()) {
				return resource;
			} else {
				throw new Exception("file not found " + fileName);
			}
		} catch (MalformedURLException e) {
			throw new Exception("file not found " + fileName, e);
		}
	}
}
