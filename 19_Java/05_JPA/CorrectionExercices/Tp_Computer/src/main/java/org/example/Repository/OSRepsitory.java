package org.example.Repository;

import org.example.Entity.Computer;
import org.example.Entity.OS;

import javax.persistence.EntityManager;
import java.util.List;

public class OSRepsitory extends BaseRepository<OS> {

    public OSRepsitory(EntityManager em) {
        super(em);
    }

    @Override
    public void save(OS element) {
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
    }

    @Override
    public void delete(OS element) {
        em.getTransaction().begin();
        em.remove(element);
        em.getTransaction().commit();
    }

    @Override
    public OS findById(int id) {
        return em.find(OS.class,id);
    }

    @Override
    public List<OS> findAll() {
        return em.createQuery("SELECT o from OS o").getResultList();
    }
}
