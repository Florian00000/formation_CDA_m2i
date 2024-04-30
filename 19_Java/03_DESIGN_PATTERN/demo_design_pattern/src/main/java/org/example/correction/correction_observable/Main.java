package org.example.correction.correction_observable;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Supplier supplier = new Supplier();

        StockManager stockManager = new StockManager();

        Product product = Product.builder().name("produit 1").observers(new ArrayList<>()).stockLevel(10).build();

        product.registerObserver(supplier);
        product.registerObserver(stockManager);

        while (true) {
            //Wait 1 second
            Thread.sleep(1000);
            product.decreaseStock();
            if(product.getStockLevel() < 5) {
                product.removeObserver(supplier);
            }
            if(product.getStockLevel() == 0)
                break;
        }

    }
}
