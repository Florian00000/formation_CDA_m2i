package org.example.service;

import org.example.entities.Produit;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
        Query<Produit> query = session.createQuery("from Produit where prix > :prix", Produit.class);
        query.setParameter("prix", number, DoubleType.INSTANCE);
        List<Produit> produits = query.list();
        session.close();
        return produits;
    }

    public List<Produit> findAllBetweenTwoDates(Date start, Date end) throws Exception {
        if (start.before(end)){
            session = sessionFactory.openSession();
            Query<Produit> query = session.createQuery("from Produit where dateAchat between ?1 and ?2", Produit.class);
            query.setParameter(1, start, DateType.INSTANCE);
            query.setParameter(2, end, DateType.INSTANCE);
            List<Produit> produits = query.list();
            session.close();
            return produits;
        }
            throw new Exception("La date du début est postérieur à la date de fin");
    }

    public List<Produit> findAllBetweenTwoDates() throws Exception {
        session = sessionFactory.openSession();

        System.out.println("Entrez la date du début");
        Date start = dateScanner();
        System.out.println("Entrez la date de fin");
        Date end = dateScanner();

        return findAllBetweenTwoDates(start, end);
    }

    public List<Produit> findAllByStockBelow(int maxStock) throws Exception {
        if (maxStock > 0){
            session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where stock < :stock", Produit.class);
            produitQuery.setParameter("stock", maxStock, IntegerType.INSTANCE);
            List<Produit> produits = produitQuery.list();
            session.close();
            return produits;
        }
        throw new Exception("Valeur entrée inférieur à 0");
    }

    public Date dateScanner() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir une date AAAA/MM/JJ");
        String dateString = scanner.nextLine();
        return new SimpleDateFormat("yyyy/MM/dd").parse(dateString);
    }



    public void close(){
        sessionFactory.close();
    }
}
