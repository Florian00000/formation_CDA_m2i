package com.example.demo_basic_hexagonal.shared.dto;

public class CommentDTO {
    private int id;
    private String content;
    private int bookId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CommentDTO(int id, String content, int bookId) {
        this.id = id;
        this.content = content;
        this.bookId = bookId;
    }
}
