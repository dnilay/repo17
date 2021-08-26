package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepoImpl;
@Component(value = "bookService")
public class BookServiceImpl implements BookService{

	private BookRepoImpl bookRepo;
	@Autowired
	public BookServiceImpl(BookRepoImpl bookRepo) {
		this.bookRepo = bookRepo;
	}

	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepo.createBook(book);
	}

}
