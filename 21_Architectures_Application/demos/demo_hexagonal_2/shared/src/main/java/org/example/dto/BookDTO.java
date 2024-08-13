package org.example.dto;

public class BookDTO {
    private String name;
    private String author;
    private int id;

    public BookDTO(String name, String author, int id) {
        this(name, author);
        this.id = id;
    }

    public BookDTO(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }
}
