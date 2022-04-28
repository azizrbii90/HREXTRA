package com.RHELP.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.RHELP.entities.Image;
import com.RHELP.repositories.ImageRepo;

@RestController
@RequestMapping(path = "check")

public class ImageController {

	@Autowired
    private ImageRepo imageRepo;

    @PostMapping("/upload")
    public Image uplaodImage(@RequestParam("myFile") MultipartFile file) throws IOException {

        Image img = new Image(file.getOriginalFilename(),file.getContentType(),file.getBytes() );
        final Image savedImage = imageRepo.save(img);
        System.out.println("Image saved");
        
        return savedImage;
    }
}
