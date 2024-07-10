package com.example.exercice_gestionrh_03.controller;

import com.example.exercice_gestionrh_03.dto.candidate.CandidateDtoGet;
import com.example.exercice_gestionrh_03.dto.candidate.CandidateDtoPost;
import com.example.exercice_gestionrh_03.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/candidate")
@CrossOrigin
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping()
    public ResponseEntity<List<CandidateDtoGet>> findAll() {
        return ResponseEntity.ok(candidateService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateDtoGet> findById(@PathVariable int id) {
        return ResponseEntity.ok(candidateService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<CandidateDtoGet> addCandidate(@RequestBody CandidateDtoPost candidateDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidateService.create(candidateDtoPost));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidateDtoGet> updateEmployee(@PathVariable int id, @RequestBody CandidateDtoPost candidateDtoPost) {
        return ResponseEntity.ok(candidateService.update(id, candidateDtoPost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        candidateService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
