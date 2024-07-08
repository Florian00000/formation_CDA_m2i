package com.example.exercice_cinematheque_02.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private LocalDate releaseDate;
    private String description;
    private int duration;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;
}
