package com.laibary.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.laibary.entity.Author;
import com.laibary.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // ✅ Get all authors
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        logger.info("Fetching all authors");
        List<Author> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    // ✅ Create new author
    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        logger.info("Creating author: {}", author.getName());
        Author savedAuthor = authorService.createAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAuthor);
    }

    // ✅ Get author by ID
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable long id) {
        logger.info("Fetching author with ID: {}", id);
        Author author = authorService.getById(id);
        return ResponseEntity.ok(author);
    }

    // ✅ Update author details
    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable long id, @RequestBody Author updatedAuthor) {
        logger.info("Updating author with ID: {}", id);
        Author author = authorService.updateAuthor(id, updatedAuthor);
        return ResponseEntity.ok(author);
    }

    // ✅ Delete author by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable long id) {
        logger.info("Deleting author with ID: {}", id);
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Delete authors by name
    @DeleteMapping("/deleteByName/{name}")
    public ResponseEntity<Void> deleteAuthorsByName(@PathVariable String name) {
        logger.info("Deleting authors with name: {}", name);
        authorService.deleteAuthorsByName(name);
        return ResponseEntity.noContent().build();
    }

    // ✅ Check if an author exists by ID
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable long id) {
        boolean exists = authorService.existsById(id);
        return ResponseEntity.ok(exists);
    }

    // ✅ Count total authors
    @GetMapping("/count")
    public ResponseEntity<Long> countAuthors() {
        long count = authorService.countAuthors();
        return ResponseEntity.ok(count);
    }

    // ✅ Get authors by name
    @GetMapping("/byName/{name}")
    public ResponseEntity<List<Author>> getAuthorsByName(@PathVariable String name) {
        List<Author> authors = authorService.getAuthorByName(name);
        return ResponseEntity.ok(authors);
    }

    // ✅ Get sorted authors by name
    @GetMapping("/sorted")
    public ResponseEntity<List<Author>> getAuthorsSortedByName() {
        List<Author> authors = authorService.getAuthorsSortedByName();
        return ResponseEntity.ok(authors);
    }
}
