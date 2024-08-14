package com.example.demo_basic_hexagonal.shared.dto;

import java.util.ArrayList;
import java.util.List;

public class BookDTO {
    private String name;
    private String author;
    private int id;
    private List<CommentDTO> commentDTOS;

    public BookDTO(String name, String author, int id) {
        this(name, author);
        this.id = id;
    }

    public BookDTO(String name, String author) {
        this.name = name;
        this.author = author;
        commentDTOS = new ArrayList<>();
    }

    public List<CommentDTO> getCommentDTOS() {
        return commentDTOS;
    }

    public void setCommentDTOS(List<CommentDTO> commentDTOS) {
        this.commentDTOS = commentDTOS;
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
