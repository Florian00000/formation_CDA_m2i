package org.example.exercice6.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String ref;
    private LocalDate dateOfPurchase;
    private double price;
    private int stock;

    public Product() {
    }

    public Product(String brand, String ref, LocalDate dateOfPurchase, double price, int stock) {
        this.brand = brand;
        this.ref = ref;
        this.dateOfPurchase = dateOfPurchase;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
