package com.bishu.bookservice.model;

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
public class BookCopyUpdateRequest {

	Integer isbn;
	Integer noOfCopies;
}