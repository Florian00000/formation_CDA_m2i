package com.example.demo_basic_hexagonal.infrastructure.springdata.repository;

import com.example.demo_basic_hexagonal.infrastructure.springdata.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookEntityRepository extends CrudRepository<BookEntity, Integer> {
}
