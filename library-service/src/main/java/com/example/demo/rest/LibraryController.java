package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Library;
import com.example.demo.service.LibraryServiceImpl;

@RestController
public class LibraryController {

	private LibraryServiceImpl libraryService;

	@Autowired
	public LibraryController(LibraryServiceImpl libraryService) {
		this.libraryService = libraryService;
	}
	@PostMapping("/libraries")
	public ResponseEntity<Library> createLibrary(@RequestBody final Library library)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(libraryService.createLibrary(library));
	}

}
