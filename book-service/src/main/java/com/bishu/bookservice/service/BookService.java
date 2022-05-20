package com.bishu.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishu.bookservice.entity.Book;
import com.bishu.bookservice.model.BookCopyUpdateRequest;
import com.bishu.bookservice.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;

	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Boolean deleteBook(Integer bookid) {
		bookRepository.deleteById(bookid);
		return true;
	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	public Book getBookById(Integer bookId) {
		Book book = bookRepository.findById(bookId).orElse(new Book());
		return book;
	}
	
	public void updateIssuedCopies(BookCopyUpdateRequest request) {
		Book book = bookRepository.findByIsbn(request.getIsbn());
		book.setIssuedCopies(book.getIssuedCopies() - request.getNoOfCopies());
		bookRepository.save(book);
	}
}
