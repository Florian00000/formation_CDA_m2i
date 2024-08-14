package com.example.demo_basic_hexagonal.domain.entity;

import java.util.List;

public class Book {
    private int id;
    private String name;
    private String author;
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(int id, String name, String author) {
        this(name, author);
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
