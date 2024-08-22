package org.example.dto.author;

import lombok.Data;
import org.example.dto.book.BookDto;
import org.example.entity.Author;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Data

public class AuthorDtoGet {

    private long id;
    private String name;
    private String biography;
    private String birthDate;
    private List<BookDto> books;

    public AuthorDtoGet(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.biography = author.getBiography();
        this.birthDate = author.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
