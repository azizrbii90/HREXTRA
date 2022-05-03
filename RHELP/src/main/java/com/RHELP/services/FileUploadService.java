package com.RHELP.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	private static String UPLOADED_FOLDER = System.getProperty("user.dir") + 
			"//images//";

	
	public String upload(MultipartFile file) {
		System.out.println("UPLOADED_FOLDER:"+UPLOADED_FOLDER+"\n");
		if (file.isEmpty())
			return null;

		String fileName = null;
		try {
			fileName = generateFileName(file.getOriginalFilename());

			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + fileName);
			System.out.println("path"+path);
			Files.write(path, bytes);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/images/" + fileName;
	}

	private String generateFileName(String file) {
		String ext = file.substring(file.lastIndexOf("."));
		String fileName = System.currentTimeMillis() + ext;
		return fileName;
	}
}
