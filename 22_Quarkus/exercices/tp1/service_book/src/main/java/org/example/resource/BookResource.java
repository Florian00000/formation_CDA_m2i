package org.example.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.dto.book.BookDtoPost;
import org.example.entity.Book;
import org.example.service.BookService;

import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookService bookService;

    @POST
    public Response createBook(BookDtoPost bookDtoPost) {
        return Response.status(201).entity(bookService.addBook(bookDtoPost)).build();
    }

    @GET
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GET
    @Path("{id}")
    public Response getBook(@PathParam("id") long id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            return Response.ok(book.get()).build();
        }else {
            return Response.status(404).build();
        }
    }

    @PUT
    @Path("{id}")
    public Response updateBook(@PathParam("id") long id, BookDtoPost bookDtoPost) {
        Book book = bookService.updateBook(bookDtoPost, id);
        if (book != null) {
            return Response.ok(book).build();
        }else{
            return Response.status(404).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteBook(@PathParam("id") long id) {
        boolean result = bookService.deleteBookById(id);
        if (result) {
            return Response.noContent().build();
        }else return Response.status(404).build();
    }

    @GET
    @Path("/author/{id}")
    public List<Book> getBooksByAuthorId(@PathParam("id") long id) {
        return bookService.getBooksByAuthorId(id);
    }

}
