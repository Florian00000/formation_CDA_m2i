package org.example.Repository;

import org.example.Entity.Agency;

import javax.persistence.EntityManager;
import java.util.List;

public class AgencyRepository extends BaseRepository<Agency>{
    public AgencyRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Agency findById(int id) {
        return em.find(Agency.class,id);
    }

    @Override
    public List<Agency> findALl() {
        return em.createQuery("select a from Agency a").getResultList();
    }
}
