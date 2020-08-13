package com.volkova.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentService {
    public static void inserts(Statement stmt) throws SQLException {
        String sql = "INSERT INTO Students (id, firstName, lastName, age, city) VALUES (100, 'Alex','Bottom',19,'New York')";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO Students (id, firstName, lastName, age, city) VALUES (102, 'Jodie','Foster',17,'Los Angeles')";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO Students (id, firstName, lastName, age, city) VALUES (103, 'Jeremy','Pearl',18,'New York')";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO Students (id, firstName, lastName, age, city) VALUES (104, 'Sara','Parker',21,'Chicago')";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO Students (id, firstName, lastName, age, city) VALUES (105, 'Walter','White',19,'Albuquerque')";
        stmt.executeUpdate(sql);
    }

    public static void selectsByAge(Statement stmt) throws SQLException {
        String sql = "SELECT id, firstName, lastName, age, city FROM Students ORDER BY age";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Sorted Table of Students: ");

        while (rs.next()) {
            System.out.println("______________________________");
            int id = rs.getInt("id");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
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
        String sql1 = "SELECT COUNT (*) AS total FROM Students";
        ResultSet rs1 = stmt.executeQuery(sql1);

        if (rs1.next()) {
            System.out.println("______________________________");
            System.out.println("Count of All Students: " + rs1.getInt("total"));
        } else {
            System.out.println("Error!!!");
        }
    }


    public static void delete(Statement stmt) throws SQLException {

        String sql = "DELETE FROM Students WHERE age BETWEEN 20 AND 45";
        stmt.executeUpdate(sql);

    }

    public static void findJName(Statement stmt) throws SQLException {

        String sql = "SELECT firstName FROM Students WHERE firstName LIKE 'J%'";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.println("______________________________");
            System.out.println("Student with name that started with J: " + rs.getString("firstName"));
        }
    }
}