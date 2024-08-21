package org.example.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.entity.Personne;
import org.example.repository.PersonneRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PersonneService {

    @Inject
    PersonneRepository personneRepository;


    @Transactional
    public Personne creerPersonne(String nom, String prenom, int age){
        Personne personne = new Personne();
        personne.setAge(age);
        personne.setNom(nom);
        personne.setPrenom(prenom);
        personneRepository.persist(personne);
        return personne;
    }

    public List<Personne> getAllPersonne(){
        return personneRepository.listAll();
    }

    public Optional<Personne> getPersonneById(Long id){
        return personneRepository.findByIdOptional(id);
    }

    public List<Personne> getPersonneByNom(String nom){
        return personneRepository.rechercheParNom(nom);
    }

    @Transactional
    public void deleteById(Long id){
        personneRepository.deleteById(id);
    }


}
