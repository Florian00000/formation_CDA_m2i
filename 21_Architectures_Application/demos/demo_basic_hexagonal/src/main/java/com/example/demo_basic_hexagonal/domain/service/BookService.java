package com.example.demo_basic_hexagonal.domain.service;

import com.example.demo_basic_hexagonal.domain.entity.Book;
import com.example.demo_basic_hexagonal.shared.dto.BookDTO;
import com.example.demo_basic_hexagonal.shared.port.BookPort;
import com.example.demo_basic_hexagonal.shared.port.CommentPort;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private final BookPort bookPort;
    private CommentPort commentPort;

    public BookService(BookPort bookPort) {
        this.bookPort = bookPort;

    }
    public BookService(BookPort bookPort, CommentPort commentPort) {
        this(bookPort);
        this.commentPort = commentPort;
    }

    public BookDTO save(String name, String author) {
        //Vérification sur la partie métier
        BookDTO book = new BookDTO(name, author);
        book =  bookPort.save(book);
        return book;
    }

    public List<BookDTO> get() {
        //Vérification sur la partie métier
//        List<BookDTO> bookDTOS = bookPort.get();
//        List<Book> books = new ArrayList<>();
//        bookDTOS.forEach(b -> books.add(new Book(b.getId(), b.getName(), b.getAuthor())));
//
//        return books;
        List<BookDTO> books = bookPort.get();
        books.forEach(bookDTO -> bookDTO.setCommentDTOS(commentPort.get(bookDTO.getId())));
        return books;

    }
}
