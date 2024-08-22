package org.example.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.entity.Book;

import java.util.List;

@ApplicationScoped
public class BookRepository implements PanacheRepository<Book> {

    public List<Book> findByAuthorId(long authorId) {
        return find("authorId", authorId).list();
    }

}
