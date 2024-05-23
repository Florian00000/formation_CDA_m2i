package org.example;

import org.example.Entity.ProductElectronic;
import org.example.Entity.ProductHousing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
        EntityManager em = emf.createEntityManager();

        ProductElectronic productElectronic = ProductElectronic.builder().price(12.2).name("on sen fout")
                .batteryDuration(5.5).build();

        ProductHousing productHousing = ProductHousing.builder().price(5).name("einbien")
                .width(56).height(2).build();

        em.getTransaction().begin();
        em.persist(productElectronic);
        em.persist(productHousing);
        em.getTransaction().commit();


        em.close();
        emf.close();
    }
}