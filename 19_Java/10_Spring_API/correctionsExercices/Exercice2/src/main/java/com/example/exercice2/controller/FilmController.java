package com.example.exercice2.controller;

import com.example.exercice2.dto.film.FilmDtoGet;
import com.example.exercice2.dto.film.FilmDtoPost;
import com.example.exercice2.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogue")
public class FilmController {

    @Autowired
    private FilmService service;

    @GetMapping("/films")
    public ResponseEntity<List<FilmDtoGet>> getALlFilm (){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/films/director/{id}")
    public ResponseEntity<List<FilmDtoGet>> getAllFilmByDirector (@PathVariable("id") int id){
        return ResponseEntity.ok(service.findAllFilmByDirector(id));
    }

    @GetMapping("/films/{id}")
    public ResponseEntity<FilmDtoGet> getFilmById(@PathVariable("id") int id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/films/add")
    public ResponseEntity<FilmDtoGet> addFilm (@Validated @RequestBody FilmDtoPost filmDtoPost){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(filmDtoPost));
    }

    @PutMapping("/films/{id}")
    public ResponseEntity<FilmDtoGet> updateFilm (@PathVariable("id") int id ,@Validated @RequestBody FilmDtoPost filmDtoPost){
        return ResponseEntity.ok(service.update(id,filmDtoPost));
    }

    @DeleteMapping("/films/{id}")
    public ResponseEntity<String> deleteFilm (@PathVariable("id") int id){
        service.delete(id);
        return ResponseEntity.ok("film with id :"+id+" is delete");
    }
}
