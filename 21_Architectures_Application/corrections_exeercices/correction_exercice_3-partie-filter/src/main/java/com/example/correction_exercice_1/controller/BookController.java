package com.example.correction_exercice_1.controller;

import com.example.correction_exercice_1.entity.Book;
import com.example.correction_exercice_1.service.BookService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestParam String name,@RequestParam String author) {
        return ResponseEntity.ok(bookService.save(name, author));
    }

    @GetMapping
    public ResponseEntity<List<Book>> get() {
        return ResponseEntity.ok(bookService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable int id) {
        return ResponseEntity.ok(bookService.findById(id));
    }
}
