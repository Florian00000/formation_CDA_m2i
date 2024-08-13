package org.example.infrastructure_spring_data.repository;


import org.example.infrastructure_spring_data.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookEntityRepository extends CrudRepository<BookEntity, Integer> {
}
