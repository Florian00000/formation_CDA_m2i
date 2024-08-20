package org.example.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.entiy.Book;
import org.example.repository.BookRepository;
import org.jboss.logging.Logger;

import java.util.List;


@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository bookRepository;

    @Inject
    Logger logger;

    @GET
    public List<Book> getBooks() {
        logger.info("return all books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/{id}")
    public Response getBook(@PathParam("id") int id) {
        logger.info("return book with id " + id);
        return Response.status(Response.Status.ACCEPTED).entity(bookRepository.getBookById(id)
                .orElseThrow(() -> new NotFoundException("Book with id " + id + " not found"))).build();
    }

    @GET
    @Path("/numberOfBook")
    @Produces(MediaType.TEXT_PLAIN)
    public int getNumberOfBooks() {
        logger.info("return books count");
        return bookRepository.getAllBooks().size();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBook(Book book) {
        logger.info("add book " + book);
        return Response.status(Response.Status.CREATED).entity(bookRepository.addBook(book)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") int id) {
        logger.info("delete book with id " + id);
        boolean deleted = bookRepository.deleteBookById(id);
        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook(Book book) {
        logger.info("update book " + book);
        return Response.status(Response.Status.ACCEPTED).entity(bookRepository.updateBook(book)).build();
    }

}
