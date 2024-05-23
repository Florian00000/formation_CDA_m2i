package org.example.Repository;

import org.example.Entity.Peripherique;

import javax.persistence.EntityManager;
import java.util.List;

public class PeripheriqueRepository extends BaseRepository<Peripherique> {
    public PeripheriqueRepository(EntityManager em) {
        super(em);
    }

    @Override
    public void save(Peripherique element) {
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Peripherique element) {
        em.getTransaction().begin();
        em.remove(element);
        em.getTransaction().commit();
    }

    @Override
    public Peripherique findById(int id) {
        return em.find(Peripherique.class,id);
    }

    @Override
    public List<Peripherique> findAll() {
        return em.createQuery("select p from Peripherique p").getResultList();
    }
}
