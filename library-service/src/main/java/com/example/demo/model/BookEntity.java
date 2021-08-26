package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "book")
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", nullable = false)
	private Integer id;
	@Column(name = "book_name", nullable = false, unique = true)
	private String bookName;
	@Column(name = "publish_date", nullable = false)
	private String publishDate;
	@Column(name = "author_name", nullable = false)
	private String authorName;
	@Column(name = "isbn_number", nullable = false, unique = true)
	private String isbn;
	@Column(name = "book_price", nullable = false)
	private Double bookPrice;
	@ManyToOne(optional = false)
	@JoinColumn(name = "library_id", nullable = false)
	private Library library;

}
