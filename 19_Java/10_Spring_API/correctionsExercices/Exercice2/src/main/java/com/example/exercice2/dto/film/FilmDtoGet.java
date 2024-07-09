package com.example.exercice2.dto.film;

import com.example.exercice2.entity.Director;
import com.example.exercice2.util.FilmType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmDtoGet {
    private int id;
    private String name;
    private LocalDate releaseDate;
    private String description;
    private int duration;
    private FilmType filmType;
    private Director director;
}
