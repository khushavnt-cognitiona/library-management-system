package com.laibary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    // 🔹 Default Constructor (Required for JPA)
    public Author() {}

    // 🔹 Parameterized Constructor
    public Author(String name) {
        this.name = name;
    }

    // 🔹 Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // 🔹 Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
