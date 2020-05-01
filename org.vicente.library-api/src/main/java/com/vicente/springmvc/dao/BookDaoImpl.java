package com.vicente.springmvc.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.vicente.springmvc.model.Book;

/**
 * Created in Eclipse IDE.
 * Project : org.vicente.library-api
 * User: yash
 * Date: 18/01/2020
 */
@Transactional
@Repository
public class BookDaoImpl implements InterfaceBookDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Book getBookById(int bookId) {
		return entityManager.find(Book.class, bookId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBooks() {
		
		String hql = "FROM Book as bo ORDER BY bo.bookId";
		return (List<Book>) entityManager.createQuery(hql).getResultList();
	}	
	
	@Override
	public void addBook(Book book) {
		entityManager.persist(book);
	}
	
	@Override
	public void updateBook(Book book) {
		
		Book bookAlter = getBookById(book.getBookId());
		bookAlter.setTitle(book.getTitle());
		bookAlter.setCategory(book.getCategory());
		entityManager.merge(bookAlter);
	}
	
	@Override
	public void deleteBook(int bookId) {
		entityManager.remove(getBookById(bookId));
	}
	
	/**
	 * Responsible method to do a check if the workbook exists in the database.
	 */
	@Override
	public boolean bookExists(String title, String category) {
		String hql = "FROM Book as bo WHERE bo.title = :title and bo.category = :category";
		int count = entityManager.createQuery(hql).setParameter("title", title).setParameter("category", category)
				.getResultList().size();
		return count > 0 ? true : false;
	}

}
