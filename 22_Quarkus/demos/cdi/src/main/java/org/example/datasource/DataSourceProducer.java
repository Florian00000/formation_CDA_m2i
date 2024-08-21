package org.example.datasource;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import org.apache.commons.dbcp2.BasicDataSource;
import org.example.qualifier.MySQL;
import org.example.qualifier.Postgres;
import org.jboss.logging.Logger;

import javax.sql.DataSource;
import java.sql.SQLException;

@ApplicationScoped
public class DataSourceProducer {


    @Inject
    Logger logger;

    @Produces
    @MySQL
    @ApplicationScoped
    public DataSource createMySQLDatasource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3307/mydb_mysql");
        dataSource.setUsername("mysqluser");
        dataSource.setPassword("mysqlpass");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        try {
            dataSource.getConnection().isValid(2);
            logger.info("Mysql Connection success");
        } catch (SQLException e) {
            logger.info("Mysql Connection failed");
            throw new RuntimeException(e);
        }

        return dataSource;
    }


    @Produces
    @Postgres
    @ApplicationScoped
    public DataSource createPostgresDatasource(){

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl("jdbc:postgresql://localhost:5432/mydb_postgres");
        dataSource.setUsername("postgresuser");
        dataSource.setPassword("postgrespass");
        dataSource.setDriverClassName("org.postgresql.Driver");

        try {
            dataSource.getConnection().isValid(2);
            logger.info("Postgres Connection success");
        } catch (SQLException e) {
            logger.info("Postgres Connection failed");
            throw new RuntimeException(e);
        }

        return dataSource;
    }



}
