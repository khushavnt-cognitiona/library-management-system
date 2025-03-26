package com.laibary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String isbn;
    private int copiesAvailable;
    
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // 🔹 Default Constructor
    public Book() {}

    // 🔹 Parameterized Constructor
    public Book(String title, String isbn, int copiesAvailable, Author author, Category category) {
        this.title = title;
        this.isbn = isbn;
        this.copiesAvailable = copiesAvailable;
        this.author = author;
        this.category = category;
    }

    // 🔹 Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    // 🔹 Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
