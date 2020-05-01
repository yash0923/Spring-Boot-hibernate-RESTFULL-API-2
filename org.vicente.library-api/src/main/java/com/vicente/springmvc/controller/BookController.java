package com.vicente.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;
import com.vicente.springmvc.model.Book;
import com.vicente.springmvc.service.InterfaceBookService;

/**
 * Created in Eclipse IDE.
 * Project : org.vicente.library-api
 * User: yash
 * Date: 18/01/2020
 */
@Controller
@RequestMapping("/api")
public class BookController {

	@Autowired
	private InterfaceBookService interfaceBookService;

	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) {
		Book book = interfaceBookService.getBookById(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> list = interfaceBookService.getAllBooks();
		return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
	}

	@PostMapping("/book")
	public ResponseEntity<Void> addBook(@RequestBody Book book, UriComponentsBuilder builder) {
		
		boolean flag = interfaceBookService.addBook(book);
		HttpHeaders headers = new HttpHeaders();
		
		if (flag == false) {
			
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		headers.setLocation(builder.path("/book/{id}").buildAndExpand(book.getBookId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/book")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		
		interfaceBookService.updateBook(book);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") Integer id) {
		
		interfaceBookService.deleteBook(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}