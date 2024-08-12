package com.example.correction_exercice_1.service;

import com.example.correction_exercice_1.annotation.Log;
import com.example.correction_exercice_1.annotation.Performance;
import com.example.correction_exercice_1.entity.Book;
import com.example.correction_exercice_1.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findById(int id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()) {
            return bookOptional.get();
        }
        throw new RuntimeException("Book not found");
    }

    @Performance
    public Book save(String name, String author) {
        if(name.length() > 3) {
            Book book = new Book();
            book.setAuthor(author);
            book.setName(name);
            return bookRepository.save(book);
        }
        throw new RuntimeException("Name must be gt 3");
    }

    @Performance
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

}

