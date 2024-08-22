package org.example.dto.book;

import lombok.Builder;
import lombok.Data;
import org.example.entity.Book;

@Data
@Builder
public class BookDtoPost {

    private String title;
    private String isbn;

    private long authorId;

    public Book toBook(){
        return Book.builder().title(this.title).isbn(this.isbn).authorId(this.authorId).build();
    }
}
