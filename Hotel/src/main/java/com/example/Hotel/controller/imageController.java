package com.example.Hotel.controller;

import com.example.Hotel.exception.ImageNotFoundException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value = "/images")
public class imageController {
    //root path for image files
    private String FILE_PATH_ROOT = "images/";

    @GetMapping("/{filename}")
    public ResponseEntity<InputStreamResource> getImage(@PathVariable("filename") String filename) {
        InputStreamResource image ;
        try {
            var imgFile = new ClassPathResource(FILE_PATH_ROOT+filename);
            
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new InputStreamResource(imgFile.getInputStream()));
        } catch (IOException e) {
            throw new ImageNotFoundException();
        }
        //return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }
}
