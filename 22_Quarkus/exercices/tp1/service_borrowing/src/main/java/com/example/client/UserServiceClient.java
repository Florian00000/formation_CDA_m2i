package com.example.client;

import com.example.dto.user.UserDtoGet;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Path("/api/users")
@RegisterRestClient(configKey = "service_user")
public interface UserServiceClient {

    @GET
    @Path("{id}")
    public UserDtoGet getUser(@PathParam("id") long id);
}
