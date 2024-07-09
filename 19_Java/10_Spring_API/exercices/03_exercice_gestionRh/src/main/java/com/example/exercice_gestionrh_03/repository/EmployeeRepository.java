package com.example.exercice_gestionrh_03.repository;

import com.example.exercice_gestionrh_03.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
