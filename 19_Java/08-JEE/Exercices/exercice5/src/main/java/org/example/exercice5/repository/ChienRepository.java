package org.example.exercice5.repository;

import org.example.exercice5.entities.Chien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class ChienRepository {

    private StandardServiceRegistry serviceRegistry;
    private SessionFactory sessionFactory;
    private Session session;

    public ChienRepository() {
        serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
    }

    public void close(){
        sessionFactory.close();
    }

    public boolean ajouterChien(Chien chien) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(chien);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Chien chienParId(int id) {
        session = sessionFactory.openSession();
        Chien chien = session.get(Chien.class, id);
        session.close();
        return chien;
    }

    public List<Chien>  listeChiens() {
        session = sessionFactory.openSession();
        List<Chien> chiens = session.createQuery("from Chien", Chien.class).list();
        session.close();
        return chiens;
    }

    public boolean suppressionChien(int id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(session.get(Chien.class, id));
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
