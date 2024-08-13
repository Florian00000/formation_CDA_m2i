package com.example.tp_hexagonal_03.infrastructure.springdata.repository;

import com.example.tp_hexagonal_03.infrastructure.springdata.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<EventEntity, Integer> {
}
