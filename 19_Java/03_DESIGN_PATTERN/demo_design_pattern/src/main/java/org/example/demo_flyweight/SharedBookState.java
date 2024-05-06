package org.example.demo_flyweight;

import java.util.List;

public class SharedBookState implements BookFlyWeight {

    private String author;
    private String category;
    private List<String> tags;

    public SharedBookState(String author, String category, List<String> tags) {
        this.author = author;
        this.category = category;
        this.tags = tags;
    }

    @Override
    public void displayBookInfo(String title, String description) {
        System.out.println(title);
        System.out.println(description);
        System.out.println(author);
        System.out.println(category);
        System.out.println(tags);
    }
}
