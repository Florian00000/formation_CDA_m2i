package org.example.exercices.exercice01Film.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Film {
    private int id_Film;
    private String titre;
    private String realisateur;
    private String genre;

    @Override
    public String toString() {
        return "Film{" +
                "id_Film =" + id_Film +
                ", titre ='" + titre + '\'' +
                ", realisateur ='" + realisateur + '\'' +
                ", genre ='" + genre + '\'' +
                '}';
    }
}
