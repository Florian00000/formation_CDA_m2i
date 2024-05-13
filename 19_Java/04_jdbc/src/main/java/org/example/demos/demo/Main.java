package org.example.demos.demo;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test_jdbc";
        String user = "root";
        String password = "root";
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connection ok");
                String request = " INSERT INTO PERSON (firstname, lastname) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, "Georges");
                preparedStatement.setString(2, "Abitbol");

                int row = preparedStatement.executeUpdate();

                ResultSet resultSetKey = preparedStatement.getGeneratedKeys();

                if (row > 0) {
                    System.out.println("Personne ajoutée");
                }
                if (resultSetKey.next()) {
                    System.out.println("id: " + resultSetKey.getInt("id"));
                }

                String request2 = "Select * FROM person";
                Statement statement2 = connection.createStatement();
                ResultSet result = statement2.executeQuery(request2);
                while (result.next()) {
                    System.out.println(result.getString("firstname") + " " + result.getString("lastname"));
                }


            } else {
                System.out.println("Echec de la Connection");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
