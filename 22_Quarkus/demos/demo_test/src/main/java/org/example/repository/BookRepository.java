package org.example.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import org.example.entiy.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    private List<Book> books = new ArrayList<>(List.of(
            new Book(1, "Le seigneur des anneaux", "Tolkien", 1956, "fantasy"),
            new Book(2, "Utopia", "Thomas More", 1516, "essai philosophique"),
            new Book(3, "Les Métamorphoses", "Ovide", 65, "poésie"),
            new Book(4, "La guerre du Péloponnèse", "Thucydide", 500, "histoire")
            ));

    public List<Book> getAllBooks(){
        return books;
    }

    public Optional<Book> getBookById(int id){
        return books.stream().filter(b -> b.getId() == id).findFirst();
    }

    public Book addBook(Book book){
        if (book == null || book.getTitle() == null){
            throw new IllegalArgumentException("The book or book title is null!");
        }
        books.add(book);
        return book;
    }

    public Book updateBook(Book book){
        if (book == null || book.getTitle() == null){
            throw new IllegalArgumentException("The book or book title is null!");
        }
        Book bookUpdated = getBookById(book.getId()).orElseThrow(() -> new NotFoundException("Book not found!"));
        bookUpdated.setTitle(book.getTitle());
        bookUpdated.setAuthor(book.getAuthor());
        bookUpdated.setYearOfPublication(book.getYearOfPublication());
        bookUpdated.setGenre(book.getGenre());
        return getBookById(book.getId()).orElseThrow(() -> new NotFoundException("Book not found!"));
    }

    public boolean deleteBookById(int id){
        Optional<Book> book = getBookById(id);
        if (book.isPresent()){
            books.remove(book.get());
            return true;
        }else {
            return false;
        }
    }

    public List<Book> getBooksByAuhor(String name){
        return books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(name)).toList();
    }

    public List<Book> getBooksByAuthorization(String token){
        if (validateTokent(token)){
            return books;
        }else {
            throw new SecurityException("Invalid token");
        }
    }

    public boolean validateTokent(String token){
        return "valide-token".equals(token);
    }
}
