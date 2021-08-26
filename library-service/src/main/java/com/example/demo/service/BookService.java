package com.example.demo.service;

import java.util.List;

import com.example.demo.model.BookEntity;

public interface BookService {
	public BookEntity createBook(BookEntity book);
	public List<BookEntity> displayAllBooks();
	public BookEntity findBookById(Integer id);
	public BookEntity updateBookById(Integer id,BookEntity bookDetail);
	public BookEntity deleteBookById(Integer id);
	
}
