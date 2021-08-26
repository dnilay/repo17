package com.example.demo.repo;

import java.util.List;

import com.example.demo.model.Book;

public interface BookRepo {
	
	public Book createBook(Book book);
	public List<Book> displayAllBooks();
}
