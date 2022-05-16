package com.bishu.bookservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloBookController {
	
	@GetMapping("/hello-book")
	public String hello() {
		return "Hello from book service";
	}

}
