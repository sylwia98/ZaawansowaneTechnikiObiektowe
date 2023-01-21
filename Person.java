package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Person {
    String username;
    String email;
    String password;
    Boolean enabled;
    Long id;

    public Person(String username, String email, String password, Boolean enabled, Long id) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.id = id;
    }

    public Person() {
    }

    void getPersons(DatabaseConnector dbc) throws SQLException {
        Statement stmt = dbc.connection.createStatement();
        String sql = "SELECT * from person";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", username " + rs.getString("username"));
            System.out.print(", email " + rs.getString("email"));
            System.out.print(", password: " + rs.getString("password"));
            System.out.println(", enabled: " + rs.getBoolean("enabled"));
        }
    }

    void addPerson(DatabaseConnector dbc) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("podaj id");
        Long id = in.nextLong();
        System.out.println("podaj nazwe uzytkownika");
        String username = in.next();
        System.out.println("podaj email");
        String email = in.next();
        System.out.println("podaj haslo");
        String password = in.next();
        System.out.println("podaj wartosc enabled: true albo false");
        Boolean enabled = in.nextBoolean();
        String insertSQL = "insert into person values (" + "'" + username + "'," + "'" + email + "'," + "'" + password + "'," + "'" + id + "'," + enabled + ")";
        Statement stmt = dbc.connection.createStatement();
        stmt.execute(insertSQL);
    }

    void deletePerson(DatabaseConnector dbc) throws SQLException {
        System.out.println("podaj id uzytkownika do usuniecia");
        Scanner in = new Scanner(System.in);
        long id = in.nextLong();
        String sql = "DELETE FROM person " + "WHERE id = " + id;
        Statement stm = dbc.connection.createStatement();
        stm.executeUpdate(sql);
    }

    void updatePerson(DatabaseConnector dbc) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("podaj id uzytkownika do aktualizacji");
        long id = in.nextLong();
        System.out.println("podaj nowa nazwe uzytkownika");
        String username = in.next();
        System.out.println("podaj nowy email");
        String email = in.next();
        System.out.println("podaj nowe haslo");
        String password = in.next();
        System.out.println("podaj nowe id");
        Long newId = in.nextLong();
        System.out.println("podaj nowa wartosc enabled: true albo false");
        Boolean enabled = in.nextBoolean();

        Statement stm = dbc.connection.createStatement();
        String sql = "UPDATE person " + "SET username = " + username + ", email = " + email  + ", password = " + password + ", enabled = " + enabled + ", id = " + newId + "WHERE id = " + id;
        stm.executeUpdate(sql);
    }
}
