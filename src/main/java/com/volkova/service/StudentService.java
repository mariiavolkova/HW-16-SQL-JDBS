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
}