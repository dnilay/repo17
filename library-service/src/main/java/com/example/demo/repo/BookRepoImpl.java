package com.example.demo.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Book;

@Component(value = "bookRepo")
@EnableTransactionManagement
public class BookRepoImpl implements BookRepo{

	private EntityManager entityManager;
	
	@Autowired
	public BookRepoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public Book createBook(Book book) {
	
		entityManager.persist(book);
	
		return book;
	}

}
