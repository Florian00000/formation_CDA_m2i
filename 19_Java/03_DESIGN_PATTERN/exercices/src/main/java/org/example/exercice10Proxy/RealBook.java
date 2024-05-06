package org.example.exercice10Proxy;

public class RealBook implements Book {
    private String title;
    private String content;


    public RealBook(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public void readBook() {
        System.out.println(content);
    }
}
