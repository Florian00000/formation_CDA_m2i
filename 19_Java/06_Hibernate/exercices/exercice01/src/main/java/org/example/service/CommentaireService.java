package org.example.service;

import org.example.entities.Commentaire;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class CommentaireService extends BaseService implements Repository<Commentaire> {

    public CommentaireService() {
        super();
    }

    @Override
    public boolean create(Commentaire o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Commentaire o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Commentaire o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Commentaire findById(int id) {
        session = sessionFactory.openSession();
        Commentaire commentaire = session.get(Commentaire.class, id);
        session.close();
        return commentaire;
    }

    @Override
    public List<Commentaire> findAll() {
        session = sessionFactory.openSession();
        Query<Commentaire> query = session.createQuery("from Commentaire", Commentaire.class);
        List<Commentaire> commentaires = query.list();
        session.close();
        return commentaires;
    }


    public void close(){
        sessionFactory.close();
    }
}