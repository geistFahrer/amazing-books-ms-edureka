package com.bishu.issuerservice.model;

import org.springframework.stereotype.Component;

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
public class BookIssueRequest {
	
	private Integer id;
	private String customerId;
	private Integer noOfCopies;

}
