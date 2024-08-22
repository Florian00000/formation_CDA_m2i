package org.example.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.dto.AuthorDtoGet;
import org.example.dto.AuthorDtoPost;
import org.example.entity.Author;
import org.example.service.AuthorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/api/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {

    @Inject
    AuthorService authorService;

    @GET
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") long id) {
        Optional<Author> author = authorService.getAuthorById(id);
        if (author.isPresent()) {
            return Response.ok(new AuthorDtoGet(author.get())).build();
        }else return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    public List<AuthorDtoGet> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return authors.stream().map(AuthorDtoGet::new).toList();
    }

    @POST
    public Response addAuthor(AuthorDtoPost authorDtoPost) {
        return Response.status(Response.Status.CREATED).entity(new AuthorDtoGet(authorService.saveAuthor(authorDtoPost))).build();
    }

    @PUT
    @Path("{id}")
    public Response updateAuthor(@PathParam("id") long id, AuthorDtoPost authorDtoPost) {
        Author author = authorService.updateAuthor(authorDtoPost, id);
        if (author != null) {
            return Response.ok(new AuthorDtoGet(author)).build();
        }else return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteAuthor(@PathParam("id") long id) {
        boolean deleted = authorService.deleteAuthor(id);
        if (deleted) {
            return Response.noContent().build();
        }else return Response.status(Response.Status.NOT_FOUND).build();
    }
}
