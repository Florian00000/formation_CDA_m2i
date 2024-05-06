package org.example.demo_flyweight;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FlyWeightFactory factory = new FlyWeightFactory();
        Book book = new Book("1984", "un livre", factory.getFlyweight("1984", "George orwell","c1", Arrays.asList("tag")));
        Book book2 = new Book("la ferme des animaux", "un livre", factory.getFlyweight("1984", "George orwell","c1", Arrays.asList("tag")));
    }
}
