package com.example.exercice2.entity;

import com.example.exercice2.util.FilmType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate releaseDate;
    @Column(columnDefinition = "text")
    private String description;
    private int duration;
    @Enumerated
    private FilmType filmType;

    @ManyToOne
    @JoinColumn(name = "id_director")
    @JsonIgnore
    private Director director;
}
