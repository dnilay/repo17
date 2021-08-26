package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookServiceImpl;

@RestController
public class BookController {

	private BookServiceImpl bookService;

	@Autowired
	public BookController(BookServiceImpl bookService) {
		this.bookService = bookService;
	}
	@PostMapping("/books")
	public ResponseEntity<Book> createBook(@RequestBody Book book)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(book));
	}

}
