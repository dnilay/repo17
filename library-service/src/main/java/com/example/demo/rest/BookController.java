package com.example.demo.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookServiceImpl;
import com.example.demo.shared.BookResponseEntity;

@RestController
public class BookController {

	private BookServiceImpl bookService;

	@Autowired
	public BookController(BookServiceImpl bookService) {
		this.bookService = bookService;
	}
	@PostMapping("/books")
	public ResponseEntity<BookResponseEntity> createBook(@RequestBody Book book)
	{
		BookResponseEntity bookResponseEntity=new BookResponseEntity();
		bookService.createBook(book);
		bookResponseEntity.setBookName(book.getBookName());
		bookResponseEntity.setBookPrice(book.getBookPrice());
		bookResponseEntity.setAuthorName(book.getAuthorName());
		bookResponseEntity.setIsbn(book.getIsbn());
		bookResponseEntity.setPublishDate(book.getPublishDate());
		bookResponseEntity.setLibraryId(book.getLibrary().getId());
		return new ResponseEntity<BookResponseEntity>(bookResponseEntity,HttpStatus.CREATED);
	}
	@GetMapping("/books")
	public ResponseEntity<List< BookResponseEntity>> displayAllBooks()
	{
		List<BookResponseEntity> list=new ArrayList<BookResponseEntity>();
		List<Book> books=bookService.displayAllBooks();
		Iterator<Book> i=books.iterator();
		while(i.hasNext())
		{
			Book book=i.next();
			BookResponseEntity bookResponseEntity=new BookResponseEntity();
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

}
