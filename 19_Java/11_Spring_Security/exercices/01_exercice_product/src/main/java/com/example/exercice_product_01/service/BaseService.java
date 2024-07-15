package com.example.exercice_product_01.service;

import java.util.List;

public interface BaseService<T> {
    T create (T object);
    T update (int id,T object);
    boolean delete (int id);
    T findById (int id);
    List<T> findAll ();
}
