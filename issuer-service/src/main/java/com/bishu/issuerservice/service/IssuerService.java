package com.bishu.issuerservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.bishu.issuerservice.entity.IssuedBook;
import com.bishu.issuerservice.model.Book;
import com.bishu.issuerservice.model.BookIssueRequest;
import com.bishu.issuerservice.model.BookIssueResponse;
import com.bishu.issuerservice.repository.IssuedBookRepository;

@Service
public class IssuerService {

	@Value("${bookms.baseUrl}")
	private String bookmsDomain;

	@Autowired
	private RestTemplate template;

	@Autowired
	IssuedBookRepository repository;

	public List<Book> getAllBooks(String token) {
		List<Book> bookList = new ArrayList<>();
		String url = new StringBuilder().append(bookmsDomain).append("show-all-books").toString();
		System.out.println("URI ::::::::::::" + url);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", token);
		ResponseEntity<Book[]> response = template.exchange(url, HttpMethod.GET, new HttpEntity<Object>(headers), Book[].class);
		Book[] books = response.getBody();

		Arrays.stream(books).forEach(book -> {
			book.setAvailableCopies(book.getTotalCopies() - book.getIssuedCopies());
			bookList.add(book);
		});

		return bookList;

	}

	public BookIssueResponse issueBook(BookIssueRequest bookIssueRequest, String token) {
		Book book = new Book();
		BookIssueResponse bookIssueResponse = null;
		String urlToGetBook = new StringBuilder().append(bookmsDomain).append("book/").append(bookIssueRequest.getId()).toString();
		String urlToUpdateBook = new StringBuilder().append(bookmsDomain).append("update-book").toString();
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", token);
		ResponseEntity<Book> response = template.exchange(urlToGetBook, HttpMethod.GET, new HttpEntity<Object>(headers), Book.class);

		if(response.getStatusCode().equals(HttpStatus.OK)) {
			book = response.getBody();
			
		}
		
		//Insert data in issue table
		int availableCopies = book.getTotalCopies() - book.getIssuedCopies();
		if(availableCopies > 0 && availableCopies >= bookIssueRequest.getNoOfCopies()) {
			IssuedBook issuedBook = IssuedBook.builder()
					  .isbn(book.getIsbn())
					  .customerId(bookIssueRequest.getCustomerId())
					  .noOfCopies(bookIssueRequest.getNoOfCopies())
					  .build();

			issuedBook = repository.save(issuedBook);

		//update the book
			
		book.setIssuedCopies(book.getIssuedCopies() + bookIssueRequest.getNoOfCopies());
		HttpEntity<Book> requestUpdate = new HttpEntity<>(book,headers);
		template.exchange(urlToUpdateBook, HttpMethod.PUT, requestUpdate, Book.class);
		
		//Create book issue response 
		bookIssueResponse = BookIssueResponse.builder()
							.issueId(issuedBook.getId())
							.bookId(book.getId())
							.isbn(book.getIsbn())
							.title(book.getTitle())
							.author(book.getAuthor())
							.publishedDate(book.getPublishedDate())
							.copiesIssued(bookIssueRequest.getNoOfCopies()).build();
		
		
		}
		
		return bookIssueResponse;
		
	}
	
	public Boolean cancelBook(Integer issueId, String token) {
		repository.deleteById(issueId);
		return true;
	} 
	
	public List<IssuedBook> getIssuedData(){
		return repository.findAll();
	}
}
