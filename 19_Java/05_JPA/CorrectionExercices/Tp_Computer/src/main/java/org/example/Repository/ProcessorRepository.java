package org.example.Repository;

import org.example.Entity.OS;
import org.example.Entity.Processor;

import javax.persistence.EntityManager;
import java.util.List;

public class ProcessorRepository extends BaseRepository<Processor> {
    public ProcessorRepository(EntityManager em) {
        super(em);
    }

    @Override
    public void save(Processor element) {
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Processor element) {
        em.getTransaction().begin();
        em.remove(element);
        em.getTransaction().commit();
    }

    @Override
    public Processor findById(int id) {
        return em.find(Processor.class,id);
    }

    @Override
    public List<Processor> findAll() {
        return em.createQuery("SELECT p from Processor p").getResultList();
    }
}
