package com.volkova.dao;

import java.sql.Statement;

public class Connection {
    public static final String JDBC_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:h2:mem:default;DB_CLOSE_DELAY=-1";

    public static final String USER = "sa";
    public static final String PASS = "";
}