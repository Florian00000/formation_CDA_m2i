package org.example.rest_adapter.controller;




import org.example.dto.BookDTO;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDTO> save(@RequestParam String name, @RequestParam String author) {
        return ResponseEntity.ok(bookService.save(name, author));
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> get() {
        return ResponseEntity.ok(bookService.get());
    }

}
