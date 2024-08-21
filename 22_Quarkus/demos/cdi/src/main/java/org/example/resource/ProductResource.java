package org.example.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.service.ProductService;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {


    @Inject
    private ProductService productService;



    @GET
    @Path("mysql")
    public Response getProductsMysql(){
        try{
            productService.printMysqlProducts();
            return Response.ok().entity("Product mysql").build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Problem avec mysql").build();
        }

    }

    @GET
    @Path("postgres")
    public Response getProductsPostgres(){
        try{
            productService.printPostGresProducts();
            return Response.ok().entity("Product postgres").build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Problem avec postgres").build();
        }

    }




}
