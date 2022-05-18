package com.bishu.issuerservice.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BookIssueResponse {
	
	private Integer issueId;
	private Integer bookId;
	private Integer isbn;
	private String title;
	private LocalDate publishedDate;
	private String author;
	private Integer copiesIssued;
	

}
