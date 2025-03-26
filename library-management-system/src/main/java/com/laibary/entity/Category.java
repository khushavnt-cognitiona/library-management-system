package com.laibary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    // 🔹 Default Constructor
    public Category() {}

    // 🔹 Parameterized Constructor
    public Category(String name) {
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
