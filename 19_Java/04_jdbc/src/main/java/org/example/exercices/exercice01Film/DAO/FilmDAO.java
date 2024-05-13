package org.example.exercices.exercice01Film.DAO;

import org.example.exercices.exercice01Film.Entity.Film;

import java.sql.*;

public class FilmDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private String request;
    private ResultSet resultSet;

    public FilmDAO(Connection connection) {
        this.connection = connection;
    }

    public Film createFilm(String titre, String realisateur, String genre) throws SQLException {
        request = "INSERT INTO film (titre, realisateur, genre) VALUES (?, ?, ?)";
        preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, titre);
        preparedStatement.setString(2, realisateur);
        preparedStatement.setString(3, genre);
        int nbRows = preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        Film film = null;
        if (resultSet.next()) {
            film = Film.builder().titre(titre).realisateur(realisateur).genre(genre).build();
        }
        return film;
    }
}
