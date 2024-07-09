package com.example.exercice2.dto.film;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmDtoPost {
    @Size(max = 255)
    private String name;
    @Pattern(regexp = "([0-9]+(-[0-9]+)+)")
    private String releaseDateStr;
    private String description;
    @Min(1)
    private int duration;
    @Min(0)
    @Max(8)
    private int filmType;
    @Min(1)
    private int directorId;
}
