package org.example.demo_api_rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

// L'annoation @Path peut etre applique à une classe ou a une methode
@Path("/hello-world")
public class HelloResource {
    @GET // http://localhost:8080/demo_api_rest_war_exploded/api/hello-world
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @GET // http://localhost:8080/demo_api_rest_war_exploded/api/hello-world/hello-you
    @Path("/hello-you")
    @Produces("text/plain")
    public String helloYou() {
        return "Hello, You!";
    }


    @GET
    @Path("/hello-json")
    @Produces("application/json")
    public String helloJson(){
        return "Hello, Json";
    }


    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String json(){
        return "Encore du Json!!";
    }
}