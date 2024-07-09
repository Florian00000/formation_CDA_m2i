package com.example.exercice2.dto.director;

import com.example.exercice2.entity.Film;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DirectorDtoGet {
    private int id;
    private String firstname;
    private String lastName;
    private LocalDate birthDate;
    private String nationality;
    private List<Film> films;
}
