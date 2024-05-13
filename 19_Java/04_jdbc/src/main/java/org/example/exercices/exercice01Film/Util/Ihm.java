package org.example.exercices.exercice01Film.Util;

import org.example.exercices.exercice01Film.DAO.FilmDAO;
import org.example.exercices.exercice01Film.Entity.Film;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Ihm {
    private Connection connection;
    private FilmDAO filmDAO;
    private Scanner scanner;

    public Ihm() {
        scanner = new Scanner(System.in);
        try {
            connection = DataBaseManager.getConnection();
            filmDAO = new FilmDAO(connection);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void start(){
        int entry;
        while(true){
            System.out.println("-- Gestion de Films --");
            System.out.println("1. Lister les films");
            System.out.println("2. Ajouter un film");
            entry = scanner.nextInt();
            scanner.nextLine();

            switch(entry){
                case 1:
                    break;
                case 2:
                    createFilm();
                    break;
                default:
                    return;
            }
        }
    }

    private void createFilm(){
        System.out.println("-- Ajout d'un film --");
        System.out.println("Titre du film");
        String titre = scanner.nextLine();
        System.out.println("Réalisateur du film");
        String realisateur = scanner.nextLine();
        System.out.println("Genre du film");
        String genre = scanner.nextLine();

        try {
            Film film = filmDAO.createFilm(titre, realisateur, genre);
            System.out.println("Le film a été ajouté " + film);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
