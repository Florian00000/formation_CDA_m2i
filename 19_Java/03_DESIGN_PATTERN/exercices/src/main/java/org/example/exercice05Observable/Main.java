package org.example.exercice05Observable;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        product.setStockLevel(25);
        System.out.println("après création");
        StockManager stockManager = new StockManager();
        Supplier supplier = new Supplier();
        product.registerObserver( stockManager);
        product.registerObserver(supplier);
        product.setStockLevel(20);
    }
}
