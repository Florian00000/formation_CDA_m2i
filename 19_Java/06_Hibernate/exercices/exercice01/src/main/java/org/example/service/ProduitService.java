package org.example.service;

import org.example.entities.Produit;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;

import java.util.Date;
import java.util.List;

public class ProduitService extends BaseService implements Repository<Produit> {

    public ProduitService(){
        super();
    }


    @Override
    public boolean create(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Produit findById(int id) {
       // Produit produit = null;
        session = sessionFactory.openSession();
        Produit produit = session.get(Produit.class,id);
        session.close();
        return produit;
    }

    @Override
    public List<Produit> findAll() {
        session = sessionFactory.openSession();
        Query<Produit> query = session.createQuery("from Produit");
        List<Produit> produits = query.list();
        session.close();
        return produits;
    }

    public List<Produit> findAllMoreExpensiveThan(double number) {
        session = sessionFactory.openSession();
        Query<Produit> query = session.createQuery("from Produit where prix > :prix");
        query.setParameter("prix", number, DoubleType.INSTANCE);
        List<Produit> produits = query.list();
        session.close();
        return produits;
    }

    public List<Produit> findAllBetweenTwoDates(Date start, Date end) {
        session = sessionFactory.openSession();
        Query<Produit> query = session.createQuery("from Produit where dateAchat between ?1 and ?2");
        query.setParameter(1, start, DateType.INSTANCE);
        query.setParameter(2, end, DateType.INSTANCE);
        List<Produit> produits = query.list();
        session.close();
        return produits;
    }



    public void close(){
        sessionFactory.close();
    }
}
