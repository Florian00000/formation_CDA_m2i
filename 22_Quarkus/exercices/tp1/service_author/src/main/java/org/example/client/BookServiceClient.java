package org.example.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.example.dto.book.BookDto;

import java.util.List;

@Path("/api/books")
@RegisterRestClient(configKey = "service_book")
public interface BookServiceClient {

    @GET
    @Path("/author/{id}")
    public List<BookDto> getBooksByAuthorId(@PathParam("id") long id);
}
