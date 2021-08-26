package com.example.demo.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.BookEntity;

@Component(value = "bookRepo")
@EnableTransactionManagement
public class BookRepoImpl implements BookRepo {

	private EntityManager entityManager;

	@Autowired
	public BookRepoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public BookEntity createBook(BookEntity book) {

		entityManager.persist(book);

		return book;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<BookEntity> displayAllBooks() {

		Query query = entityManager.createQuery("SELECT B FROM BookEntity B", BookEntity.class);

		return query.getResultList();
	}

	@Override
	@Transactional
	public BookEntity findBookById(Integer id) {
		Query query = entityManager.createQuery("SELECT B FROM BookEntity B where B.id=:book_id", BookEntity.class);
		query.setParameter("book_id", id);
		@SuppressWarnings("unchecked")
		List<BookEntity> list = query.getResultList();
		if(list.isEmpty())
		{
			throw new BookNotFoundException("book with the given id not found");
		}
	BookEntity book = list.get(0);
		return book;
	}

}
