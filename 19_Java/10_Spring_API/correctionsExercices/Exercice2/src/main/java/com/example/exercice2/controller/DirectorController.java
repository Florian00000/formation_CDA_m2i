package com.example.exercice2.controller;

import com.example.exercice2.dto.director.DirectorDtoGet;
import com.example.exercice2.dto.director.DirectorDtoPost;
import com.example.exercice2.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogue")
public class DirectorController {
    @Autowired
    private DirectorService service;

    @GetMapping("/director")
    public ResponseEntity<List<DirectorDtoGet>> getALlFilm (){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/director/{id}")
    public ResponseEntity<DirectorDtoGet> getFilmById(@PathVariable("id") int id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/director/add")
    public ResponseEntity<DirectorDtoGet> addFilm (@Validated @RequestBody DirectorDtoPost filmDtoPost){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(filmDtoPost));
    }

    @PutMapping("/director/{id}")
    public ResponseEntity<DirectorDtoGet> updateFilm (@PathVariable("id") int id ,@Validated @RequestBody DirectorDtoPost filmDtoPost){
        return ResponseEntity.ok(service.update(id,filmDtoPost));
    }

    @DeleteMapping("/director/{id}")
    public ResponseEntity<String> deleteFilm (@PathVariable("id") int id){
        service.delete(id);
        return ResponseEntity.ok("director with id :"+id+" is delete");
    }
}
