package org.example.exercice6.services;

import org.example.exercice6.models.Product;
import org.example.exercice6.repository.ProductRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductService {

    private ProductRepository productRepository;
    private SessionFactory _sessionFactory;
    private Session session;

    public ProductService(SessionFactory _sessionFactory) {
        this._sessionFactory = _sessionFactory;
    }

    public List<Product> getAllProducts() {
        List<Product> products = null;
        session = _sessionFactory.openSession();
        productRepository = new ProductRepository(session);
        try {
            products = productRepository.findAll();
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }finally {
            session.close();
        }
        return products;
    }
}
