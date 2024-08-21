package org.example.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.entity.Product;
import org.example.service.ProductService;

import java.util.List;
import java.util.Optional;

@Path("/api/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GET
    @Path("{id}")
    public Response getProduct(@PathParam("id") long id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            return Response.ok(product.get()).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createProduct(Product product) {
        return Response.status(201).entity(productService.createProduct(
                product.getName(), product.getDescription(), product.getPrice())).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteProduct(@PathParam("id") long id) {
        productService.deleteProductsById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("{id}")
    public Response updateProduct(@PathParam("id") long id, Product product) {
        return Response.ok().entity(productService.updateProductById(id, product)).build();
    }
}
