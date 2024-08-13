package com.example.demo_basic_hexagonal.infrastructure.springdata.portimpl;

import com.example.demo_basic_hexagonal.infrastructure.springdata.entity.BookEntity;
import com.example.demo_basic_hexagonal.infrastructure.springdata.repository.BookEntityRepository;
import com.example.demo_basic_hexagonal.shared.dto.BookDTO;
import com.example.demo_basic_hexagonal.shared.port.BookPort;

import java.util.List;

public class BookPortImpl implements BookPort {

    private final BookEntityRepository bookEntityRepository;

    public BookPortImpl(BookEntityRepository bookEntityRepository) {
        this.bookEntityRepository = bookEntityRepository;
    }

    @Override
    public BookDTO save(BookDTO book) {
        BookEntity bookEntity = BookEntity.builder().name(book.getName()).author(book.getAuthor()).build();
        bookEntity = bookEntityRepository.save(bookEntity);
        return new BookDTO(bookEntity.getName(), bookEntity.getAuthor(), bookEntity.getId());
    }

    @Override
    public List<BookDTO> get() {
        return ((List<BookEntity>)bookEntityRepository.findAll()).stream()
                .map((bookEntity -> new BookDTO(bookEntity.getName(), bookEntity.getAuthor(), bookEntity.getId())))
                .toList();
    }
}
