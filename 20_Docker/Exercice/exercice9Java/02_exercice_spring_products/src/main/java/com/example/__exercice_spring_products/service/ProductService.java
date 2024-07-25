package com.example.__exercice_spring_products.service;

import com.example.__exercice_spring_products.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductService {

    private Map<UUID, Product> products;

    public ProductService() {
        products = new HashMap<>();

        Product productA = Product.builder().id(UUID.randomUUID()).name("Yaourtator").category("jeux").price(12.25).build();
        Product productB = Product.builder().id(UUID.randomUUID()).name("Le cyclimse dans tous ses états").category("flim").price(1.25).build();
        Product productC = Product.builder().id(UUID.randomUUID()).name("spartiates").category("sandalles").price(66.6).build();
        Product productD = Product.builder().id(UUID.randomUUID()).name("marteau").category("cuisine").price(25.50).build();

        products.put(productA.getId(), productA);
        products.put(productB.getId(), productB);
        products.put(productC.getId(), productC);
        products.put(productD.getId(), productD);
    }

    public List<Product> getAllProducts() {
        return products.values().stream().toList();
    }

    public Product getProduct(UUID id) {
        return products.get(id);
    }
}
