package org.example.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.entity.Client;
import org.example.service.ClientService;

import java.util.List;
import java.util.Optional;

@Path("/api/clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientResource {

    @Inject
    ClientService clientService;

    @GET
    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    @GET
    @Path("{id}")
    public Response getClient(@PathParam("id") long id) {
        Optional<Client> client = clientService.getClientById(id);
        if (client.isPresent()) {
            return Response.ok(client.get()).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createClient(Client client) {
        return Response.status(201).entity(clientService.createClient(
                client.getName(), client.getEmail(), client.getPhone())).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteClient(@PathParam("id") long id) {
        clientService.deleteClientById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("{id}")
    public Response updateClient(@PathParam("id") long id, Client client) {
        return Response.ok().entity(clientService.updateClientById(id, client)).build();
    }
}
