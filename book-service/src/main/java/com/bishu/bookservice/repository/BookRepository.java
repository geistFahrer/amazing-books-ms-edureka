package com.bishu.bookservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bishu.bookservice.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	public Book findByIsbn(Integer isbn);

}
