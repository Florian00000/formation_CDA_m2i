package com.example.repository;

import com.example.entity.Borrowing;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class BorrowingRepository implements PanacheRepository<Borrowing> {
}
