package com.example.client;

import com.example.dto.book.BookDtoGet;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Path("/api/books")
@RegisterRestClient(configKey = "service_book")
public interface BookServiceClient {

    @GET
    @Path("{id}")
    public BookDtoGet getBook(@PathParam("id") long id);
}
