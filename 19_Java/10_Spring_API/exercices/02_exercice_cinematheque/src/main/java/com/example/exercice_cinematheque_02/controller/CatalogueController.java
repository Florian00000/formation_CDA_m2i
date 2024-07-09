package com.example.exercice_cinematheque_02.controller;

import com.example.exercice_cinematheque_02.dto.DirectorDtoGet;
import com.example.exercice_cinematheque_02.dto.DirectorDtoPost;
import com.example.exercice_cinematheque_02.dto.MovieDtoGet;
import com.example.exercice_cinematheque_02.dto.MovieDtoPost;
import com.example.exercice_cinematheque_02.service.DirectorService;
import com.example.exercice_cinematheque_02.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("catalogue/")
public class CatalogueController {

    @Autowired
    private DirectorService directorService;

    @Autowired
    private MovieService movieService;

    @PostMapping("realisateur")
    public ResponseEntity<DirectorDtoGet> addDirector(@Validated @RequestBody DirectorDtoPost directorDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(directorService.createDirector(directorDtoPost));
    }

    @GetMapping("realisateur")
    public ResponseEntity<List<DirectorDtoGet>> getDirectors() {
        return ResponseEntity.ok(directorService.getAllDirectors());
    }

    @GetMapping("realisateur/{id}")
    public ResponseEntity<DirectorDtoGet> getDirectorById(@PathVariable int id) {
        return ResponseEntity.ok(directorService.getDirector(id));
    }

    @PutMapping("realisateur/{id}")
    public ResponseEntity<DirectorDtoGet> updateDirector(@PathVariable int id, @Validated @RequestBody DirectorDtoPost directorDtoPost) {
        return ResponseEntity.ok(directorService.updateDirector(id, directorDtoPost));
    }

    @DeleteMapping("realisateur/{id}")
    public ResponseEntity<String> deleteDirector(@PathVariable int id) {
        directorService.deleteDirector(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //films
    @GetMapping("films")
    public ResponseEntity<List<MovieDtoGet>> getMovies(@RequestParam(name = "director", required = false) Integer idDirector) {
        if (idDirector == null) {
            return ResponseEntity.ok(movieService.getAllMovies());
        }else return ResponseEntity.ok(movieService.getMoviesByIdDirector(idDirector));

    }

    @GetMapping("film/{id}")
    public ResponseEntity<MovieDtoGet> getMovieById(@PathVariable int id) {
        return ResponseEntity.ok(movieService.getMovie(id));
    }

    @PostMapping("films")
    public ResponseEntity<MovieDtoGet> addMovie(@Validated @RequestBody MovieDtoPost movieDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.createMovie(movieDtoPost));
    }

    @PutMapping("film/{id}")
    public ResponseEntity<MovieDtoGet> updateMovie(@PathVariable int id, @Validated @RequestBody MovieDtoPost movieDtoPost) {
        return ResponseEntity.ok(movieService.updateMovie(id, movieDtoPost));
    }

    @DeleteMapping("film/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

