package com.laibary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laibary.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
