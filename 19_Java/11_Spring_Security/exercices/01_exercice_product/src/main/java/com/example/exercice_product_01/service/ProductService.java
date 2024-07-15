package com.example.exercice_product_01.service;

import com.example.exercice_product_01.entity.Product;
import com.example.exercice_product_01.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements BaseService<Product> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product object) {
        return productRepository.save(object);
    }

    @Override
    public Product update(int id, Product object) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setName(object.getName());
            product.setPrice(object.getPrice());
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }
}
