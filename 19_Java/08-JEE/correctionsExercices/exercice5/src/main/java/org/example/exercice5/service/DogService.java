package org.example.exercice5.service;

import org.example.exercice5.model.Dog;
import org.example.exercice5.repository.DogRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;

public class DogService {

    private DogRepository dogRepository;
    private SessionFactory _sessionFactory;
    private Session session;

    public DogService(SessionFactory sessionFactory){
        _sessionFactory = sessionFactory;
    }

    public Dog getDog(int id){
        Dog dog = null;
        session = _sessionFactory.openSession();
        dogRepository = new DogRepository(session);
        try {
            dog = dogRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return dog;
    }

    public boolean createDog(String name, String breed, LocalDate birthday){
        boolean result = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        dogRepository= new DogRepository(session);
        Dog dog = new Dog(name,breed,birthday);
        try {
            dogRepository.create(dog);
            session.getTransaction().commit();
            result = true;
        }catch (Exception except){
            try {
                session.getTransaction().rollback();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            session.close();
        }
        return result;
    }
    public List<Dog> getDogs(){
        List<Dog> dogs = null;
        session = _sessionFactory.openSession();
        dogRepository = new DogRepository(session);
        try {
            dogs = dogRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            session.close();
        }
        return dogs;
    }

}
