package org.example.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.example.dto.ProductDto;

@Path("/api/products")
@RegisterRestClient(configKey = "microservice_product")
public interface ProductServiceClient {

    @GET
    @Path("{id}")
    public ProductDto getProduct(@PathParam("id") long id);
}
