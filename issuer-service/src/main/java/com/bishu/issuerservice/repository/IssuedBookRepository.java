package com.bishu.issuerservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bishu.issuerservice.entity.IssuedBook;

@Repository
public interface IssuedBookRepository extends JpaRepository<IssuedBook, Integer>{

}
