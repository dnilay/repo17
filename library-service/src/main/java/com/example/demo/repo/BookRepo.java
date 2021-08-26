package com.example.demo.repo;

import java.util.List;

import com.example.demo.model.BookEntity;

public interface BookRepo {
	
	public BookEntity createBook(BookEntity book);
	public List<BookEntity> displayAllBooks();
	public BookEntity findBookById(Integer id);
	public BookEntity updateBookById(Integer id,BookEntity bookDetail);
}
