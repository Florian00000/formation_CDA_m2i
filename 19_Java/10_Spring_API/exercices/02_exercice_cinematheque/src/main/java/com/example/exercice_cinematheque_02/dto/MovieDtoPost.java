package com.example.exercice_cinematheque_02.dto;

import com.example.exercice_cinematheque_02.entity.Director;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDtoPost {

    @Size(min = 2, max = 50)
    private String title;

    private String releaseDate;

    @Size(min = 10, max = 255)
    private String description;

    @Min(60)
    private int duration;
    
    @Size(min = 2, max = 10)
    private String genre;

    private Director director;
}
