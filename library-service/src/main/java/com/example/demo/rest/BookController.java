package com.example.demo.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookEntity;
import com.example.demo.service.BookServiceImpl;
import com.example.demo.shared.BookResponseEntity;

@RestController
public class BookController {

	private BookServiceImpl bookService;

	@Autowired
	public BookController(BookServiceImpl bookService) {
		this.bookService = bookService;
	}

	// create a new book
	@PostMapping("/books")
	public ResponseEntity<BookResponseEntity> createBook(@RequestBody BookEntity book) {
		BookResponseEntity bookResponseEntity = new BookResponseEntity();
		bookService.createBook(book);
		bookResponseEntity.setBookName(book.getBookName());
		bookResponseEntity.setBookPrice(book.getBookPrice());
		bookResponseEntity.setAuthorName(book.getAuthorName());
		bookResponseEntity.setIsbn(book.getIsbn());
		bookResponseEntity.setPublishDate(book.getPublishDate());
		bookResponseEntity.setLibraryId(book.getLibrary().getId());
		return new ResponseEntity<BookResponseEntity>(bookResponseEntity, HttpStatus.CREATED);
	}

	// display all available books
	@GetMapping("/books")
	public ResponseEntity<List<BookResponseEntity>> displayAllBooks() {
		List<BookResponseEntity> list = new ArrayList<BookResponseEntity>();
		List<BookEntity> books = bookService.displayAllBooks();
		Iterator<BookEntity> i = books.iterator();
		while (i.hasNext()) {
			BookEntity book = i.next();
			BookResponseEntity bookResponseEntity = new BookResponseEntity();
			bookResponseEntity.setBookName(book.getBookName());
			bookResponseEntity.setBookPrice(book.getBookPrice());
			bookResponseEntity.setAuthorName(book.getAuthorName());
			bookResponseEntity.setIsbn(book.getIsbn());
			bookResponseEntity.setPublishDate(book.getPublishDate());
			bookResponseEntity.setLibraryId(book.getLibrary().getId());
			list.add(bookResponseEntity);
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);

	}

	@GetMapping("/books/{id}")
	public ResponseEntity<BookResponseEntity> findBookById(@PathVariable("id") Integer id) {
		BookEntity book = bookService.findBookById(id);
		BookResponseEntity bookResponseEntity = new BookResponseEntity();
		bookResponseEntity.setBookName(book.getBookName());
		bookResponseEntity.setBookPrice(book.getBookPrice());
		bookResponseEntity.setAuthorName(book.getAuthorName());
		bookResponseEntity.setIsbn(book.getIsbn());
		bookResponseEntity.setPublishDate(book.getPublishDate());
		bookResponseEntity.setLibraryId(book.getLibrary().getId());
		return ResponseEntity.status(HttpStatus.FOUND).body(bookResponseEntity);
	}

	@PutMapping("/books")
	public ResponseEntity<BookResponseEntity> updateBookById(@RequestParam(name = "bookId") Integer bookId,
			@RequestBody BookEntity bookEntity) {
		
		BookEntity book = bookService.updateBookById(bookId,bookEntity);
		BookResponseEntity bookResponseEntity = new BookResponseEntity();
		bookResponseEntity.setBookName(book.getBookName());
		bookResponseEntity.setBookPrice(book.getBookPrice());
		bookResponseEntity.setAuthorName(book.getAuthorName());
		bookResponseEntity.setIsbn(book.getIsbn());
		bookResponseEntity.setPublishDate(book.getPublishDate());
		bookResponseEntity.setLibraryId(book.getLibrary().getId());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookResponseEntity);

	}

}
