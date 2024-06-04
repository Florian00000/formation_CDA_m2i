package org.example.exercice05;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class Shop {
    private List<Product> products;

    public void update(Product product) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("exception");
    }
}
