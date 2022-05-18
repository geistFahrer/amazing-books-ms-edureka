package com.bishu.issuerservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

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
@Entity
public class IssuedBook {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IssuedBook_seq_generator")
	@SequenceGenerator(name = "IssuedBook_seq_generator", sequenceName = "issuedbook_seq")
	private Integer id;
	private Integer isbn;
	private String customerId;
	private Integer noOfCopies;
}
