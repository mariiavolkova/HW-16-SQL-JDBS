package com.volkova.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentService {
    public static void inserts(Statement stmt) throws SQLException {
        String sql = "INSERT INTO Students" + "VALUES (100, 'Alex','Bottom',19,'New York')";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO Students" + "VALUES (101, 'Alex','Bottom',19,'New York')";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO Students" + "VALUES (102, 'Jodie','Foster',17,'Los Angeles')";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO Students" + "VALUES (103, 'Jeremy','Pearl',18,'New York')";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO Students" + "VALUES (104, 'Sara','Parker',21,'Chicago')";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO Students" + "VALUES (105, 'Walter','White',19,'Albuquerque')";
        stmt.executeUpdate(sql);
    }

    public static void selectsByAge(Statement stmt) throws SQLException {
        String sql = "SELECT id, first name, last name, age, city FROM Students ORDER BY age";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first name");
            String lastName = rs.getString("last name");
            int age = rs.getInt("age");
            String city = rs.getString("city");

            System.out.println("ID: " + id);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Age: " + age);
            System.out.println("City: " + city);
        }
    }

    public static void count(Statement stmt) throws SQLException {
        String sql = "SELECT COUNT (*) AS All Students FROM Students";
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println(rs);
    }


    public static void delete(Statement stmt) throws SQLException {
        String sql = "DELETE FROM Student WHERE age>20 OR age<45";
        ResultSet rs = stmt.executeQuery(sql);
    }

    public static void findJName(Statement stmt) throws SQLException {
        String sql = "SELECT * FROM Students WHERE first name LIKE 'J'";
        ResultSet rs = stmt.executeQuery(sql);
    }
}