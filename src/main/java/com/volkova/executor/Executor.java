package com.volkova.executor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.volkova.JDBS.JDBS.*;
import static com.volkova.JDBS.JDBS.PASS;
import static com.volkova.service.StudentService.*;

public class Executor {
    static Connection conn = null;
    static Statement stmt = null;

    public static void execute() {
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            Executor.createTable();
            System.out.println("Created table in given database...");
            inserts(stmt);
            selectsByAge(stmt);
            count(stmt);
            delete(stmt);
            findJName(stmt);

            stmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Goodbye!");
        }
    }

    static void createTable() throws SQLException {
        stmt = conn.createStatement();
        String sql = "CREATE TABLE STUDENTS " +
                "(id INTEGER not NULL, " +
                " firstName VARCHAR(255), " +
                " lastName VARCHAR(255), " +
                " age INTEGER, " +
                "city VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        stmt.executeUpdate(sql);
    }
}