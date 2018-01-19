package com.job4me.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {

	
	private static String UPLOADED_FOLDER_CV = "/Users/itebkhayati/git/job4me_backend/upload-dir-cv/";
	private static String UPLOADED_FOLDER_LETTRE = "/Users/itebkhayati/git/job4me_backend/upload-dir-lettre/";

	@CrossOrigin("*")
	@PostMapping("/upload_cv")
	public ResponseEntity<String> cvFileUpload(@RequestParam("file") MultipartFile file) {
		String message = "";
		
		if (file.isEmpty()) {

			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}

		try {
			
			
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER_CV + file.getOriginalFilename());
			Files.write(path, bytes);

			message = "You successfully uploaded " + file.getOriginalFilename() + "!";

		} catch (IOException e) {
			e.printStackTrace();
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}

		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	
	
	
	
	
	@CrossOrigin("*")
	@PostMapping("/upload_lettre")
	public ResponseEntity<String> lettreFileUpload(@RequestParam("file") MultipartFile file) {
		String message = "";
		
		if (file.isEmpty()) {

			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}

		try {
			
			
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER_LETTRE + file.getOriginalFilename());
			Files.write(path, bytes);

			message = "You successfully uploaded " + file.getOriginalFilename() + "!";

		} catch (IOException e) {
			e.printStackTrace();
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}

		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
}