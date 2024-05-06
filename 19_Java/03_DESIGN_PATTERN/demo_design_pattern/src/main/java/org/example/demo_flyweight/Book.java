package org.example.demo_flyweight;

public class Book {
    private String title;
    private String description;

    private BookFlyWeight flyWeight;

    public Book(String title, String description, BookFlyWeight flyWeight) {
        this.title = title;
        this.description = description;
        this.flyWeight = flyWeight;
    }

    public void display() {
        this.flyWeight.displayBookInfo(title, description);
    }
}
