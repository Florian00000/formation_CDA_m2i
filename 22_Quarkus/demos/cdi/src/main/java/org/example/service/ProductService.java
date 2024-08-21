package org.example.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.qualifier.MySQL;
import org.example.qualifier.Postgres;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.jboss.logging.Logger;

@ApplicationScoped
public class ProductService {


    @Inject
    Logger logger;

    @Inject
    @MySQL
    private DataSource mysqlDataSource;


    @Inject
    @Postgres
    private DataSource postgresDataSource;

    public void printMysqlProducts(){
        String query = "SELECT id, name, price FROM products";
        try {
            Connection connection = mysqlDataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            logger.info("Liste des products : ");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                logger.info("id : " + id + " name : " + name + " price : " + price);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void printPostGresProducts(){
        String query = "SELECT id, name, price FROM products";
        try {
            Connection connection = postgresDataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            logger.info("Liste des products : ");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                logger.info("id : " + id + " name : " + name + " price : " + price);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




}
