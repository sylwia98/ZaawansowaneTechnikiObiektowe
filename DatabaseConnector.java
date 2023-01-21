package org.example;

import java.sql.*;


public class DatabaseConnector {
    public static final String HOST = "jdbc:postgresql://snuffleupagus.db.elephantsql.com/";
    public static final String DATABASE = "xzevthre";
    public static final String USERNAME = "xzevthre";
    public static final String PASS = "3icAI4j8i_Dr6FMyaLkuTWVP_ayey_1i";
    public Connection connection;


    public  void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager
                    .getConnection(HOST+DATABASE, USERNAME, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
