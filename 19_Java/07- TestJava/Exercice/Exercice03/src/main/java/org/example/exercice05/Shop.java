package org.example.exercice05;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class Shop {
    private List<Product> products;

    public void update(Product product)  {

        product.setSellIn(product.getSellIn() - 1 );

        if ( !product.getName().equals("brie vieilli")) {
            if (product.getSellIn() > 0){
            product.setQuality(product.getQuality() - 1);
            } else {
                product.setQuality(product.getQuality() - 2);
            }
        }else {
            product.setQuality(product.getQuality() + 1);
        }


        if (product.getQuality() == 0){
            product.setQuality( 1);
        } else if (product.getQuality() > 50) {
            product.setQuality(50);
        }

    }
}
