package com.bishu.bookservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bishu.bookservice.entity.Book;
import com.bishu.bookservice.service.BookService;

@RefreshScope
@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Value("${message:Hello books}")
	private String message;
	
	@GetMapping("/hello-book-ms")
	public String hello() {
		return message + "updated";
	}
	
	@PostMapping("/add-book")
	public ResponseEntity<Book> addBook(@RequestBody Book book){
				
		book = bookService.addBook(book);
		ResponseEntity<Book> response = ResponseEntity.status(HttpStatus.CREATED).body(book);
		
		return response;
		
	}
	
	@GetMapping("/show-all-books")
	public ResponseEntity<List<Book>> getAllBooks(){
		
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
		
	}
	
	@GetMapping("/book/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable Integer bookId){
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(bookId));
		
	}
	
	@DeleteMapping("/delete-book/{book-id}")
	public ResponseEntity<String> deleteBook(@PathVariable(name = "book-id") Integer bookId){
		
		bookService.deleteBook(bookId);
		
		return ResponseEntity.status(HttpStatus.OK).body(String.format("Book with Id %s deleted successfully", bookId));
		
	}
	
	@PutMapping("/update-book")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @RequestHeader(value="Authorization") String token){
		System.out.println("Token :::::::::::::::::::::::::::::::::" + token);
		book = bookService.updateBook(book);
		ResponseEntity<Book> response = ResponseEntity.status(HttpStatus.OK).body(book);
		
		return response;
		
	}

}
