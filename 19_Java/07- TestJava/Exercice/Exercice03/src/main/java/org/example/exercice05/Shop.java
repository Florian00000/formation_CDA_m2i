package org.example.exercice05;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class Shop {
    private List<Product> products;

    public void update(Product product)  {
        product.setSellIn(product.getSellIn() - 1 );
        if (product.getSellIn() > 0){
            product.setQuality(product.getQuality() - 1);
        } else {
            product.setQuality(product.getQuality() - 2);
        }

        if (product.getQuality() == 0){
            product.setQuality( 1);
        }

    }
}
