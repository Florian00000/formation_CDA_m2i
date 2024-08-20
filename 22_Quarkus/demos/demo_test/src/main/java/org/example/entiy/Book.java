package org.example.entiy;

import jakarta.ws.rs.FormParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @FormParam("id")
    private int id;

    @FormParam("title")
    private String title;

    @FormParam("author")
    private String author;

    @FormParam("yearOfPublication")
    private int yearOfPublication;

    @FormParam("genre")
    private String genre;
}
