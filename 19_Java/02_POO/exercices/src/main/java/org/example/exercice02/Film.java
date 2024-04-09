package org.example.exercice02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Film {
    private String titre;
    private String realisateur;
    private LocalDate anneeSortie;
    private String genre;

    public Film(String titre, String realisateur, LocalDate anneeSortie, String genre){
        this.titre = titre;
        this.realisateur = realisateur;
        this.anneeSortie = anneeSortie;
        this.genre = genre;
    }

    public String toString(){
        return "titre: " + this.titre + ", réalisateur: " + this.realisateur + ", date de sortie: " + this.anneeSortie.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)) + ", genre: " + this.genre ;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public LocalDate getAnneeSortie() {
        return anneeSortie;
    }

    public void setAnneeSortie(LocalDate anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
