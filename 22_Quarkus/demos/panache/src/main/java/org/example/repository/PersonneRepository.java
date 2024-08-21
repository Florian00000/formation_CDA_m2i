package org.example.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.entity.Personne;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PersonneRepository implements PanacheRepository<Personne> {


    public List<Personne> rechercheParNom(String nom){
        return find("nom", nom).list();
    }

    public Personne rechercheParNomFirst(String nom){
        return find("nom", nom).firstResult();
    }

    public Optional<Personne> rechercheParNomFirstOptional(String nom){
        return find("nom", nom).firstResultOptional();
    }

    public List<Personne> rechercheParNomEtParPrenom(String nom, String prenom){
        return find("nom = ?1 and prenom = ?2", nom, prenom).list();
    }

    public List<Personne> rechercheParNomEtParPrenomNomme(String nom, String prenom){
        return find("nom = :nom and prenom = :prenom", Parameters.with("nom", nom).and("prenom",prenom)).list();
    }


    public List<Personne> rechercheParAge(int age){
        return find("age > ?1", age).list();
    }

    public List<Personne> rechercheParAgeEntre(int minage, int maxage){
        return find("age >= ?1 and age <= ?2", minage, maxage).list();
    }

    public List<Personne> rechercheParMoyenneAge(){
        return find("age > (select avg(age) from Personne)").list();
    }

    public List<Personne> rechercheParNomSufix(String suffixe){

        return find("nom like ?1","%" + suffixe).list();
    }

}
