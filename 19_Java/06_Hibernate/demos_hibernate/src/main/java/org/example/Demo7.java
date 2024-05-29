package org.example;

import org.example.entities.Adresse;
import org.example.entities.Entreprise;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Demo7 {
    public static void main(String[] args) {
        // Démo avec un cascade type remove
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // premiere partie creation d'une entreprise avec une adresse
        /*
        Transaction transaction = session.getTransaction();
        transaction.begin();

        Entreprise entreprise = new Entreprise();
        entreprise.setNom("M2I");
        session.save(entreprise);

        Adresse adresse = new Adresse();
        adresse.setRue("rue quelque chose");
        adresse.setVille("V.d'Ascq");

        entreprise.setAdresse(adresse);
        adresse.setEntreprise(entreprise);

        session.save(adresse);

        transaction.commit();

        session.close();
        sessionFactory.close();

         */
        // Apres avoir execute la premiere partie seul on obtiens une entreprise avec une adresse en BDD

        // Seconde partie nous allons supprimer l'entreprise
        Transaction transaction = session.getTransaction();
        transaction.begin();

        Entreprise entreprise = session.get(Entreprise.class,2); // 2 est l'id d'entreprise cree dans la partie 1 ( a modifie au besoin )
        session.remove(entreprise);

        transaction.commit();

        session.close();
        sessionFactory.close();

    }
}
