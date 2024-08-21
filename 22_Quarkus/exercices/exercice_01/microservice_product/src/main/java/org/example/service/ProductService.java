package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.entity.Product;
import org.example.repository.ProductRepository;


import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    @Transactional
    public Product createProduct(String name, String description, float price) {
        Product client = Product.builder().name(name).description(description).price(price).build();
        productRepository.persist(client);
        return client;
    }

    public Optional<Product> getProductById(long id) {
        return productRepository.findByIdOptional(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.listAll();
    }

    @Transactional
    public void deleteProductsById(long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public Product updateProductById(long id, Product product) {
        Product updatedProduct = productRepository.findByIdOptional(id).orElseThrow();
        updatedProduct.setName(product.getName());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setPrice(product.getPrice());
        productRepository.persist(updatedProduct);
        return updatedProduct;
    }
}
