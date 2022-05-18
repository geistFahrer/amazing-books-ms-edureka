/**
 * 
 */
package com.bishu.bookservice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author biroy
 *
 */

@Setter @Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq_generator")
	@SequenceGenerator(name = "book_seq_generator", sequenceName = "book_seq")
	private Integer id;
	
	@Column(unique = true)
	private Integer isbn;
	
	private String title;
	private LocalDate publishedDate;
	private Integer totalCopies;
	private Integer issuedCopies;
	private String author;

}
