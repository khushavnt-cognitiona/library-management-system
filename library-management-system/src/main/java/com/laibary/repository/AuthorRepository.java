package com.laibary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laibary.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	List<Author> findByName(String name);

	List<Author> findAllByOrderByNameAsc();

	void deleteByName(String name);
}
