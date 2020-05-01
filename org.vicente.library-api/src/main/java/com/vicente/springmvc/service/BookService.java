package com.vicente.springmvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vicente.springmvc.dao.InterfaceBookDao;
import com.vicente.springmvc.model.Book;

/**
 * Created in Eclipse IDE.
 * Project : org.vicente.library-api
 * User: yash
 * Date: 18/01/2020
 */
@Service
public class BookService implements InterfaceBookService {

	@Autowired
	private InterfaceBookDao interfaceBookDAO;

	@Override
	public Book getBookById(int bookId) {
		Book obj = interfaceBookDAO.getBookById(bookId);
		return obj;
	}

	@Override
	public List<Book> getAllBooks() {
		return interfaceBookDAO.getAllBooks();
	}

	@Override
	public synchronized boolean addBook(Book book) {
		
		if (interfaceBookDAO.bookExists(book.getTitle(), book.getCategory())) {
			
			return false;
			
		} else {
			
			interfaceBookDAO.addBook(book);
			return true;
		}
	}

	@Override
	public void updateBook(Book book) {
		
		interfaceBookDAO.updateBook(book);
	}

	@Override
	public void deleteBook(int bookId) {
		
		interfaceBookDAO.deleteBook(bookId);
	}

}