package com.example.demo_basic_hexagonal.domain.service;

import com.example.demo_basic_hexagonal.domain.entity.Book;
import com.example.demo_basic_hexagonal.shared.dto.BookDTO;
import com.example.demo_basic_hexagonal.shared.port.BookPort;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private final BookPort bookPort;

    public BookService(BookPort bookPort) {
        this.bookPort = bookPort;
    }

    public Book save(String name, String author) {
        //Vérification sur la partie métier
        BookDTO book = new BookDTO(name, author);
        book =  bookPort.save(book);
        return new Book(book.getId(), book.getName(), book.getAuthor());
    }

    public List<Book> get() {
        //Vérification sur la partie métier
//        List<BookDTO> bookDTOS = bookPort.get();
//        List<Book> books = new ArrayList<>();
//        bookDTOS.forEach(b -> books.add(new Book(b.getId(), b.getName(), b.getAuthor())));
//
//        return books;
        return bookPort.get()
                .stream()
                .map((b -> new Book(b.getId(), b.getName(), b.getAuthor())))
                .toList();
    }
}
