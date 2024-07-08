package com.example.exercice_cinematheque_02.controller;

import com.example.exercice_cinematheque_02.dto.DirectorDtoGet;
import com.example.exercice_cinematheque_02.dto.DirectorDtoPost;
import com.example.exercice_cinematheque_02.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("catalogue/")
public class CatalogueController {

    @Autowired
    private DirectorService directorService;

    @PostMapping("realisateur")
    public ResponseEntity<DirectorDtoGet> addDirector(@RequestBody DirectorDtoPost directorDtoPost) {
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
    public ResponseEntity<DirectorDtoGet> updateDirector(@PathVariable int id, @RequestBody DirectorDtoPost directorDtoPost) {
        return ResponseEntity.ok(directorService.updateDirector(id, directorDtoPost));
    }

    @DeleteMapping("realisateur/{id}")
    public ResponseEntity<String> deleteDirector(@PathVariable int id) {
        directorService.deleteDirector(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Réalisateur "+id+" supprimé");
    }
}
