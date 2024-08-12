package com.example.exercice_aspect_01.controller;

import com.example.exercice_aspect_01.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;


@RestController
@RequestMapping("")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getBook(@PathVariable int id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @PostMapping()
    public ResponseEntity<String> addBook(@RequestBody String book) {
        if (bookService.addBook(book)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(book);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur");
        }
    }
}
