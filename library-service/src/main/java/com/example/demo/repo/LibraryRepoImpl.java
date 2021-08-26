package com.example.demo.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Library;

@Component(value = "libraryRepo")
@EnableTransactionManagement
public class LibraryRepoImpl implements LibraryRepo {

	private EntityManager entityManager;

	@Autowired
	public LibraryRepoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public Library createLibrary(Library library) {
		entityManager.persist(library);

		return library;
	}

}
