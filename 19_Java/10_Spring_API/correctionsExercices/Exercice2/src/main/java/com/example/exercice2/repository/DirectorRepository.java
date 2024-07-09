package com.example.exercice2.repository;

import com.example.exercice2.entity.Director;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface DirectorRepository extends CrudRepository<Director,Integer> {
}
