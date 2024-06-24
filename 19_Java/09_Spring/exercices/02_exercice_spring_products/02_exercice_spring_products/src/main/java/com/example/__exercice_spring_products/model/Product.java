package com.example.__exercice_spring_products.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Product {
    private UUID id;
    private String name;
    private String category;
    private double price;
}
