package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.dto.AuthorDtoPost;
import org.example.entity.Author;
import org.example.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AuthorService {

    @Inject
    AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.listAll();
    }

    public Optional<Author> getAuthorById(long id) {
        return authorRepository.findByIdOptional(id);
    }

    @Transactional
    public Author saveAuthor(AuthorDtoPost authorDtoPost) {
        Author author = authorDtoPost.toAuthor();
        authorRepository.persist(author);
        return author;
    }

    @Transactional
    public Author updateAuthor(AuthorDtoPost authorDtoPost, long id) {
        Optional <Author> author = getAuthorById(id);
        if (author.isPresent()) {
            author.get().setName(authorDtoPost.getName());
            author.get().setBiography(authorDtoPost.getBiography());
            author.get().setBirthDate(authorDtoPost.toAuthor().getBirthDate());
            authorRepository.persist(author.get());
            return author.get();
        }else {
            return null;
        }
    }

    @Transactional
    public boolean deleteAuthor(long id) {
        authorRepository.deleteById(id);
        return true;
    }
}
