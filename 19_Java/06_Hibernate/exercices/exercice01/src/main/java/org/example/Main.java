package org.example;

import org.example.entites.Produit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();

        /*
        //créer
        Produit produit1 = Produit.builder().marque("marque1").reference("ref1").dateAchat(new Date()).prix(5.5).stock(5).build();
        Produit produit2 = Produit.builder().marque("marque2").reference("ref2").dateAchat(new Date()).prix(5.5).stock(5).build();
        Produit produit3 = Produit.builder().marque("marque3").reference("ref3").dateAchat(new Date()).prix(5.5).stock(5).build();
        Produit produit4 = Produit.builder().marque("marque4").reference("ref4").dateAchat(new Date()).prix(5.5).stock(5).build();
        Produit produit5 = Produit.builder().marque("marque5").reference("ref5").dateAchat(new Date()).prix(5.5).stock(5).build();

        session.save(produit1);
        session.save(produit2);
        session.save(produit3);
        session.save(produit4);
        session.save(produit5);

         */

        //Read
//        Produit readProduit = session.get(Produit.class, 2);
//        System.out.println(readProduit);

        //Supprimer
        /*
        Produit deleteProduit = session.get(Produit.class, 3);
        session.getTransaction().begin();
        session.delete(deleteProduit);
        session.getTransaction().commit();

         */
        //update
        Produit updateProduit = session.get(Produit.class, 1);
        System.out.println("produit non modifié " + updateProduit);
        updateProduit.setMarque("update marque");
        System.out.println("Produit modifié " + updateProduit);
        session.getTransaction().begin();
        session.update(updateProduit);
        session.getTransaction().commit();




        session.close();
        sessionFactory.close();
    }
}