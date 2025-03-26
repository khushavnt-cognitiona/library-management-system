package com.laibary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laibary.entity.Author;
import com.laibary.repository.AuthorRepository;

@Service
public class  AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	
	public List<Author>getAllAuthor(){
		
		return authorRepository.findAll();
		
		
	}
	public Author createAuthor(Author author) {
		
		return authorRepository.save(author);
		
	}

}
