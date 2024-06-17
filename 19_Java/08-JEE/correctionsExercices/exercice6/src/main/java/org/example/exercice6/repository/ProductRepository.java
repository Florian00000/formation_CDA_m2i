package org.example.exercice6.repository;

import org.example.exercice6.exception.NotFoundException;
import org.example.exercice6.model.Product;
import org.hibernate.Transaction;

import java.util.List;

public class ProductRepository extends BaseRepository<Product> {

    public ProductRepository(){
        super();
    }

    @Override
    public Product add(Product entity) {
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return entity;
    }

    @Override
    public Product finfById(int id) {
        Product product = null;

        try {
            session = sessionFactory.openSession();
            product = session.get(Product.class,id);
            if (product == null){
                throw new NotFoundException("Product not found");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return product;
    }

    @Override
    public Product update(Product entity) {
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return entity;
    }

    @Override
    public boolean delete(Product entity) {
        Transaction transaction = null;
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
            result = true;
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

        return result;
    }

    public List<Product> findAll(){
        List<Product> products = null;
        try {
            session = sessionFactory.openSession();
            products = session.createQuery("from Product ").list();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return products;

    }
}
