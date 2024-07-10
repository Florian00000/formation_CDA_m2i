package com.example.exercice_gestionrh_03.repository;

import com.example.exercice_gestionrh_03.entity.Absence;
import com.example.exercice_gestionrh_03.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AbsenceRepository extends CrudRepository<Absence, Integer> {
    List<Absence> findAllByEmployee(Employee employee);
}
