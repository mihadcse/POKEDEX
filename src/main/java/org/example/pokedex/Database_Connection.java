package org.example.pokedex;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database_Connection {
    public Connection databaseLink;
    public Connection getConnection() {
        String databaseName = "pokedex";
        String databaseUser = "root";
        String databasePassword = "dBase@BookPlanGo24";
        String url = "jdbc:mysql://localhost/" + databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection (url, databaseUser, databasePassword);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }
}
