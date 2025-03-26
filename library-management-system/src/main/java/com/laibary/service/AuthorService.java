package com.laibary.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laibary.entity.Author;
import com.laibary.exception.AuthorNotFoundException;
import com.laibary.repository.AuthorRepository;

@Service
public class AuthorService {

    private static final Logger logger = LoggerFactory.getLogger(AuthorService.class);
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        logger.info("Fetching all authors");
        return authorRepository.findAll();
    }

    public Author createAuthor(Author author) {
        logger.info("Creating new author: {}", author.getName());
        return authorRepository.save(author);
    }

    public Author getById(long id) {
        Optional<Author> author = authorRepository.findById(id);
        
        if (author.isPresent()) {
            return author.get();
        } else {
            throw new AuthorNotFoundException("Author with ID " + id + " not found");
        }
    }


    public Author updateAuthor(long id, Author updatedAuthor) {
        Author existingAuthor = getById(id);
        existingAuthor.setName(updatedAuthor.getName());
        logger.info("Updating author with ID: {}", id);
        return authorRepository.save(existingAuthor);
    }

    public void deleteAuthor(long id) {
        Author author = getById(id);
        logger.info("Deleting author with ID: {}", id);
        authorRepository.delete(author);
    }

    @Transactional
    public void deleteAuthorsByName(String name) {
        logger.info("Deleting authors with name: {}", name);
        authorRepository.deleteByName(name);
    }

    public boolean existsById(long id) {
        return authorRepository.existsById(id);
    }

    public long countAuthors() {
        return authorRepository.count();
    }

    public List<Author> getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    public List<Author> getAuthorsSortedByName() {
        return authorRepository.findAllByOrderByNameAsc();
    }
}
