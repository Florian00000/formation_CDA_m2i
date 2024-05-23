package org.example.Repository;

import org.example.Entity.Computer;

import javax.persistence.EntityManager;
import java.util.List;

public class ComputerRepository extends  BaseRepository<Computer> {

    public ComputerRepository(EntityManager em) {
        super(em);
    }

    @Override
    public void save(Computer element) {
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Computer element) {
        em.getTransaction().begin();
        em.remove(element);
        em.getTransaction().commit();
    }

    @Override
    public Computer findById(int id) {
        return em.find(Computer.class,id);
    }

    @Override
    public List<Computer> findAll() {
        return em.createQuery("SELECT c from Computer c").getResultList();
    }
}
