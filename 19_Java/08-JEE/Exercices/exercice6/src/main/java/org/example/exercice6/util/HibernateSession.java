package org.example.exercice6.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSession {

    private static StandardServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;




    public static SessionFactory getSessionFactory(){

        // TODO Ne trouve pas le .env
//        try {
//            Configuration configuration = new Configuration();
//            configuration.configure("hibernate.cfg.xml");
//
//            configuration.setProperty("hibernate.connection.password", Env.getEnv("DB_PASSWORD"));
//
//            System.out.println("Hibernate properties set:");
//            System.out.println("Password: " + configuration.getProperty("hibernate.connection.password"));
//
//
//            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).configure().build();
//
//            sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
//        } catch (Exception e){
//            e.printStackTrace();
//            if (serviceRegistry != null){
//                StandardServiceRegistryBuilder.destroy(serviceRegistry);
//            }
//        }

        //Partie sans le .env
        serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

        return sessionFactory;
    }
}
