package org.example.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.entiy.Book;
import org.example.repository.BookRepository;

import java.util.List;

@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource1 {

    @Inject
    BookRepository bookRepository;

    @GET
    @Path("/about")
    @Produces(MediaType.TEXT_HTML)
    public String getAboutBook(){
        return "<html><body><h1> La Bibliothèque!!!!! </h1></body></html>";
    }

    @GET
    @Path("/author")
    public List<Book> getBooksByAuhor(@QueryParam( "author") String author){
        return bookRepository.getBooksByAuhor(author);
    }

    @GET
    @Path("/authorization")
    public List<Book> getBooksByAuthorization(@HeaderParam("Authorization" )String token){
        return bookRepository.getBooksByAuthorization(token);
    }

    @POST
    @Path("/form")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addBook(@FormParam("id") int id,
                            @FormParam("title") String title,
                            @FormParam("author") String author,
                            @FormParam("yearOfPublication") int yearOfPublication,
                            @FormParam("genre") String genre){
        Book book = new Book(id, title, author, yearOfPublication, genre);
        return Response.status(201).entity(bookRepository.addBook(book)).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public List<Book> addBookAndReturnAllBooks(@BeanParam Book book){
        bookRepository.addBook(book);
        return bookRepository.getAllBooks();
    }
}
