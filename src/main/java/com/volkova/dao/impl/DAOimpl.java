package com.volkova.dao.impl;

import com.volkova.dao.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOimpl implements DAO {

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

    public static void showUserAfterDeleteOperations(Statement stmt) throws SQLException {
        String sql = "SELECT * FROM Students";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("All Students after Delete: ");
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
}
