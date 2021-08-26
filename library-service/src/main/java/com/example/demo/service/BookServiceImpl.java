package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.BookEntity;
import com.example.demo.repo.BookRepoImpl;
@Component(value = "bookService")
public class BookServiceImpl implements BookService{

	private BookRepoImpl bookRepo;
	@Autowired
	public BookServiceImpl(BookRepoImpl bookRepo) {
		this.bookRepo = bookRepo;
	}

	@Override
	public BookEntity createBook(BookEntity book) {
		// TODO Auto-generated method stub
		return bookRepo.createBook(book);
	}

	@Override
	public List<BookEntity> displayAllBooks() {
		// TODO Auto-generated method stub
		return bookRepo.displayAllBooks();
	}

	@Override
	public BookEntity findBookById(Integer id) {
		// TODO Auto-generated method stub
		return bookRepo.findBookById(id);
	}

	@Override
	public BookEntity updateBookById(Integer id, BookEntity bookDetail) {
		
		return bookRepo.updateBookById(id, bookDetail);
	}

	@Override
	public BookEntity deleteBookById(Integer id) {
		// TODO Auto-generated method stub
		return bookRepo.deleteBookById(id);
	}

}
