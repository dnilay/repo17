package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Library;
import com.example.demo.repo.LibraryRepoImpl;

@Component(value = "libraryService")
public class LibraryServiceImpl implements LibraryService {
	private LibraryRepoImpl libraryRepo;

	@Autowired
	public LibraryServiceImpl(LibraryRepoImpl libraryRepo) {
		this.libraryRepo = libraryRepo;
	}

	@Override
	public Library createLibrary(Library library) {
		// TODO Auto-generated method stub
		return libraryRepo.createLibrary(library);
	}

}
