package org.example.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.entity.Personne;
import org.example.service.PersonneService;

import java.util.List;
import java.util.Optional;

@Path("/personnes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonneResource {

    @Inject
    PersonneService personneService;


    @POST
    @Path("/create")
    public Response creePersonne(Personne personne) {
        Personne nouvellePersonne = personneService.creerPersonne(personne.getNom(), personne.getPrenom(), personne.getAge());
        return Response.ok(nouvellePersonne).status(201).build();
    }

    @GET
    public List<Personne> recupereToutesLesPersonnes() {
        return personneService.getAllPersonne();
    }

    @GET
    @Path("{id}")
    public Response trouveUnePersonneParId(@PathParam("id") Long id) {
        Optional<Personne> personne = personneService.getPersonneById(id);
        return personne.map(pers -> Response.ok(pers).build()).orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path("/nom/{nom}")
    public List<Personne> trouveParNom(@PathParam("nom") String nom) {
        return personneService.getPersonneByNom(nom);
    }


    @DELETE
    @Path("{id}")
    public Response supprimeUnePersonne(@PathParam("id") Long id){
        personneService.deleteById(id);
        return Response.noContent().build();
    }


}



