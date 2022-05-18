package com.bishu.issuerservice.model;

import java.time.LocalDate;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Book {
	
	private Integer id;
	private Integer isbn;
	private String title;
	private LocalDate publishedDate;
	private Integer totalCopies;
	private Integer issuedCopies;
	private Integer availableCopies;
	private String author;
	
}
