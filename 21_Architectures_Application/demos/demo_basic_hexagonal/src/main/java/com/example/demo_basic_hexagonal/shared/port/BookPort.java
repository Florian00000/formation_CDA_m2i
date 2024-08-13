package com.example.demo_basic_hexagonal.shared.port;

import com.example.demo_basic_hexagonal.domain.entity.Book;
import com.example.demo_basic_hexagonal.shared.dto.BookDTO;

import java.util.List;

public interface BookPort {
    BookDTO save(BookDTO book);
    List<BookDTO> get();
}
