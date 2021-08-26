package com.example.demo.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookResponseEntity {
	private String bookName;
	private String publishDate;
	private String authorName;
	private String isbn;
	private Double bookPrice;
	private Integer libraryId;
}
