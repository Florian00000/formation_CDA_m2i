package org.example.demo_api_rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.demo_api_rest.service.PersonService;

// L'annoation @Path peut etre applique à une classe ou a une methode
@Path("/hello-world")
public class HelloResource {



    private final PersonService personService;


    @Inject
    public HelloResource(PersonService personService){
        this.personService = personService;
    }

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

    // Méthodes pour ajouter des donées
    /*
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
   // public Person postPerson(@FormParam("name")String name,@FormParam("age")int age){
    public Person postPerson(@QueryParam("name") String name,@QueryParam("age") int age){
       // return personService.save(4,"titi",58);
        return personService.save(4,name,age);
    }
    */





}