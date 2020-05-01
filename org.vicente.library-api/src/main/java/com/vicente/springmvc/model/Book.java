package com.vicente.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * Created in Eclipse IDE.
 * Project : org.vicente.library-api
 * User: yash
 * Date: 18/01/2020
 */
@Entity
@Table(name = "book")
public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="book_id")
    private int bookId;

	@NotEmpty
	@NotBlank
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="category")	
	private String category;
	
	public String getTitle() {
		return title;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [id=" + bookId + ", Name=" + title + ", "
				+ "Category=" + category + "]";
	}
}
