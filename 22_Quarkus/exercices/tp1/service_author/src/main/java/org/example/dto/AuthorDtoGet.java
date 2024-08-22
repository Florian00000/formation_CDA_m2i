package org.example.dto;

import lombok.Data;
import org.example.entity.Author;

import java.time.format.DateTimeFormatter;

@Data

public class AuthorDtoGet {

    private long id;
    private String name;
    private String biography;
    private String birthDate;

    public AuthorDtoGet(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.biography = author.getBiography();
        this.birthDate = author.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
