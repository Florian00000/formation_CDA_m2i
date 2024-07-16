package com.m2ibank.repository;

import com.m2ibank.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    Optional<Customer> findByEmail(String email);
}
