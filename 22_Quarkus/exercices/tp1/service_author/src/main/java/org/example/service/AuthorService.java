package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.example.client.BookServiceClient;
import org.example.dto.author.AuthorDtoGet;
import org.example.dto.author.AuthorDtoPost;
import org.example.dto.book.BookDto;
import org.example.entity.Author;
import org.example.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AuthorService {

    @Inject
    AuthorRepository authorRepository;

    @Inject
    @RestClient
    BookServiceClient bookServiceClient;

    public List<AuthorDtoGet> getAllAuthors() {
        List<Author> authors =  authorRepository.listAll();
        return authors.stream().map(this::enrichAuthor).toList();
    }

    public AuthorDtoGet getAuthorById(long id) {
        Optional<Author> author = authorRepository.findByIdOptional(id);
        return author.map(this::enrichAuthor).orElse(null);
    }

    @Transactional
    public Author saveAuthor(AuthorDtoPost authorDtoPost) {
        Author author = authorDtoPost.toAuthor();
        authorRepository.persist(author);
        return author;
    }

    @Transactional
    public AuthorDtoGet updateAuthor(AuthorDtoPost authorDtoPost, long id) {
        Optional <Author> author = authorRepository.findByIdOptional(id);
        if (author.isPresent()) {
            author.get().setName(authorDtoPost.getName());
            author.get().setBiography(authorDtoPost.getBiography());
            author.get().setBirthDate(authorDtoPost.toAuthor().getBirthDate());
            authorRepository.persist(author.get());
            return enrichAuthor(author.get());
        }else {
            return null;
        }
    }

    @Transactional
    public boolean deleteAuthor(long id) {
        authorRepository.deleteById(id);
        return true;
    }

    private AuthorDtoGet enrichAuthor(Author author) {
        List<BookDto> books = bookServiceClient.getBooksByAuthorId(author.getId());
        if (books.isEmpty()) {
            return new AuthorDtoGet(author);
        }else {
            AuthorDtoGet authorDtoGet = new AuthorDtoGet(author);
            authorDtoGet.setBooks(books);
            return authorDtoGet;
        }
    }
}
