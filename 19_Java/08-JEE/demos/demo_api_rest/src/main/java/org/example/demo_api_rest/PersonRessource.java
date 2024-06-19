package org.example.demo_api_rest;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.demo_api_rest.service.PersonService;

@Path("/persons")
public class PersonRessource {

    private final PersonService personService;


    @Inject
    public PersonRessource(PersonService personService){
        this.personService = personService;
    }

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

    // Méthodes pour ajouter des donées avec parametres dans l'url ( ?name=value)
    @POST
   // @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Person postPerson(@QueryParam("name") String name,@QueryParam("age") int age){
        return personService.save(4,name,age);
    }

    // Méthodes pour ajouter des donées avec objet json dans le corps de ma requete
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person postPerson(Person person){
        return person;
    }


    @DELETE
    @Path("{id}")
    public int delete(@PathParam("id")int id){
        return id;
    }
}
