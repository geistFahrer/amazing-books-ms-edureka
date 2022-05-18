package com.bishu.issuerservice.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bishu.issuerservice.entity.IssuedBook;
import com.bishu.issuerservice.model.Book;
import com.bishu.issuerservice.model.BookIssueRequest;
import com.bishu.issuerservice.model.BookIssueResponse;
import com.bishu.issuerservice.service.IssuerService;

@RefreshScope
@RestController
@RequestMapping("/issuer")
public class IssuerController {
	
	@Value("${message:Hello issuer}")
	private String message;
	
	@Autowired
	IssuerService issuerService;
	
	@GetMapping("/hello-issuer-ms")
	public String hello() {
		return message;
	}
	
	@GetMapping("/show-all-books")
	public ResponseEntity<List<Book>> getAllBooks(@RequestHeader(value="Authorization") String token){
		
		return ResponseEntity.status(HttpStatus.OK).body(issuerService.getAllBooks(token));
		
	}
	
	@PostMapping("/issue-book")
	public ResponseEntity<BookIssueResponse> issueBook(@RequestBody BookIssueRequest bookIssueRequest,
			@RequestHeader(value="Authorization") String token){
		
		
		return ResponseEntity.status(HttpStatus.OK).body(issuerService.issueBook(bookIssueRequest, token));
	}
	
	@DeleteMapping("/cancel/{issueId}")
	public ResponseEntity<String> cancelBook(@PathVariable Integer issueId,
			@RequestHeader(value="Authorization") String token){
		issuerService.cancelBook(issueId, token);
		return ResponseEntity.status(HttpStatus.OK).body(String.format("Book Issue with Id %s cancelled successfully", issueId));
	} 
	
	@GetMapping("/issued")
	public ResponseEntity<List<IssuedBook>> getIssuedData(){
		
		return ResponseEntity.status(HttpStatus.OK).body(issuerService.getIssuedData());
		
	}
}
