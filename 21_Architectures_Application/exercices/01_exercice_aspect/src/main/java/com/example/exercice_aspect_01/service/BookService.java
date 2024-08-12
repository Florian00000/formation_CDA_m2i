package com.example.exercice_aspect_01.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {

    private int id = 2;

    private HashMap<Integer, String> books = new HashMap<>(Map.of(
            1, "Utopia",
            2, "Common Sens"
    ));

    public boolean addBook(String title) {
        books.put(++id, title);
        return true;
    }

    public String getBook(int id) {
        return books.get(id);
    }

    public boolean removeBook(int id) {
        books.remove(id);
        return true;
    }
}
