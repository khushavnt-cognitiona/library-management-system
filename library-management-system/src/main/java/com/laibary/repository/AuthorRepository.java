package com.laibary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laibary.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
