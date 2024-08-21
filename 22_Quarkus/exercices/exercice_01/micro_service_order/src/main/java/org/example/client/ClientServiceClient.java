package org.example.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.example.dto.ClientDto;

@Path("/api/clients")
@RegisterRestClient(configKey = "microservice_client")
public interface ClientServiceClient {

    @GET
    @Path("{id}")
    public ClientDto getClient(@PathParam("id") long id);

}
