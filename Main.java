package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnector dbc = new DatabaseConnector();
        dbc.connect();
        Person person = new Person();

        System.out.println("1 wyswietl liste osob\n 2 dodaj nowa osobe\n  3 zaktualizuj dane osoby\n 4 usun osobe\n inne numery spowoduja opuszczenie programu");
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        while (id < 5 && id != 0) {
            switch (id) {
                case 1:
                    person.getPersons(dbc);
                    System.out.println("1 wyswietl liste osob\n 2 dodaj nowa osobe\n  3 zaktualizuj dane osoby\n 4 usun osobe\n inne numery spowoduja opuszczenie programu");
                    id = in.nextInt();
                    break;
                case 2:
                    person.addPerson(dbc);
                    System.out.println("1 wyswietl liste osob\n 2 dodaj nowa osobe\n  3 zaktualizuj dane osoby\n 4 usun osobe\n inne numery spowoduja opuszczenie programu");
                    id = in.nextInt();
                    break;
                case 3:
                    person.updatePerson(dbc);
                    System.out.println("1 wyswietl liste osob\n 2 dodaj nowa osobe\n  3 zaktualizuj dane osoby\n 4 usun osobe\n inne numery spowoduja opuszczenie programu");
                    id = in.nextInt();
                    break;
                case 4:
                    person.deletePerson(dbc);
                    System.out.println("1 wyswietl liste osob\n 2 dodaj nowa osobe\n  3 zaktualizuj dane osoby\n 4 usun osobe\n inne numery spowoduja opuszczenie programu");
                    id = in.nextInt();
                    break;
            }
        }
        System.out.print("Program zostaje zamkniety");
    }
}