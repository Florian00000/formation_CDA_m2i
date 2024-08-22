package org.example.dto.author;

import lombok.Data;
import org.example.entity.Author;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class AuthorDtoPost {

    private String name;
    private String biography;
    private String birthDate;

    public Author toAuthor(){
        return Author.builder()
                .name(name)
                .biography(biography)
                .birthDate(LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .build();
    }
}
