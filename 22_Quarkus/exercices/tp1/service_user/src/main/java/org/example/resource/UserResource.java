package org.example.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.dto.UserDtoGet;
import org.example.dto.UserDtoPost;
import org.example.service.UserService;

import java.util.List;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @GET
    @Path("{id}")
    public UserDtoGet getUser(@PathParam("id") Long id) {
        return userService.getUserById(id);
    }

    @GET
    public List<UserDtoGet> getAllUsers() {
        return userService.getAllUsers();
    }

    @POST
    public Response createUser(UserDtoPost userDtoPost) {
        return Response.status(201).entity(userService.addUser(userDtoPost)).build();
    }

    @PUT
    @Path("{id}")
    public Response updateUser(@PathParam("id") long id, UserDtoPost userDtoPost) {
        UserDtoGet userDtoGet = userService.updateUser(id,userDtoPost);
        if (userDtoGet == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }else return Response.status(Response.Status.OK).entity(userDtoGet).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") long id) {
        boolean result = userService.deleteUser(id);
        if (result) {
            return Response.noContent().build();
        }else return Response.status(Response.Status.NOT_FOUND).build();
    }
}
