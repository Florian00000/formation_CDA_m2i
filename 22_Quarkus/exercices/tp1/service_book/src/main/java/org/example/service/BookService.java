package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.dto.BookDtoPost;
import org.example.entity.Book;
import org.example.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookService {

    @Inject
    BookRepository bookRepository;

    @Transactional
    public Book addBook(BookDtoPost bookDtoPost) {
        Book book = bookDtoPost.toBook();
        bookRepository.persist(book);
        return book;
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findByIdOptional(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.listAll();
    }

    @Transactional
    public Book updateBook(BookDtoPost bookDtoPost, long id) {
        Optional<Book> book = getBookById(id);
        if (book.isPresent()) {
            book.get().setTitle(bookDtoPost.getTitle());
            book.get().setIsbn(bookDtoPost.getIsbn());
            bookRepository.persist(book.get());
            return book.get();
        }else {
            return null;
        }
    }

    @Transactional
    public boolean deleteBookById(long id) {
        bookRepository.deleteById(id);
        return true;
    }
}
