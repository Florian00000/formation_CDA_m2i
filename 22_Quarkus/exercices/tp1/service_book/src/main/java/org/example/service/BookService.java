package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.example.client.AuthorServiceClient;
import org.example.dto.author.AuthorDtoGet;
import org.example.dto.book.BookDtoPost;
import org.example.entity.Book;
import org.example.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookService {

    @Inject
    BookRepository bookRepository;


    @Inject
    @RestClient
    AuthorServiceClient authorServiceClient;

    @Transactional
    public Book addBook(BookDtoPost bookDtoPost) {
        Book book = bookDtoPost.toBook();
        bookRepository.persist(book);
        return book;
    }

    public Optional<Book> getBookById(Long id) {
        Optional<Book> book = bookRepository.findByIdOptional(id);
        book.ifPresent(this::enrichBook);
        return book;
    }

    public List<Book> getAllBooks() {
        return bookRepository.listAll().stream().map(this::enrichBook).toList();
    }

    @Transactional
    public Book updateBook(BookDtoPost bookDtoPost, long id) {
        Optional<Book> book = getBookById(id);
        if (book.isPresent()) {
            book.get().setTitle(bookDtoPost.getTitle());
            book.get().setIsbn(bookDtoPost.getIsbn());
            book.get().setAuthorId(bookDtoPost.getAuthorId());
            bookRepository.persist(book.get());
            return enrichBook(book.get());
        }else {
            return null;
        }
    }

    @Transactional
    public boolean deleteBookById(long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public List<Book> getBooksByAuthorId(long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    private Book enrichBook(Book book) {
        if (book.getAuthorId() != null) {
            AuthorDtoGet author = authorServiceClient.getAuthorById(book.getAuthorId());
            if (author == null) throw new WebApplicationException("Author not found" + book.getAuthorId(), 404);

            book.setAuthor(author);
        }
        return book;
    }
}
