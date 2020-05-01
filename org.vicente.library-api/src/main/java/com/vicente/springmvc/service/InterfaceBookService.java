package com.vicente.springmvc.service;

import java.util.List;
import com.vicente.springmvc.model.Book;

/**
 * Created in Eclipse IDE.
 * Project : org.vicente.library-api
 * User: yash
 * Date: 18/01/2020
 */
public interface InterfaceBookService {

	List<Book> getAllBooks();
	Book getBookById(int bookId);
	boolean addBook(Book book);
	void updateBook(Book book);
	void deleteBook(int bookId);
}
