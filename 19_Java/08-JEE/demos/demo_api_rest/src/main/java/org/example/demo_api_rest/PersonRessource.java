package org.example.demo_api_rest;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/persons")
public class PersonRessource {

    @GET
    @Path("/single")
    @Produces("application/json")
    public Person getOnePerson(){

        return new Person(1,"toto",50);
    }


    @GET
    @Path("/other")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getOtherPerson(){

        return new Person(2,"tata",24);
    }
}
