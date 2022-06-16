package com.algonquin.loggy.dao;

import java.sql.Connection;

public class DBConnection {

    // Database Schema
    // CREATE DATABASE loggy DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
    // CREATE TABLE logs (uuid CHAR(40) NOT NULL PRIMARY KEY, title CHAR(128),
    // content TEXT, createTimestamp Date);

    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static Connection getConnectionToDatabase() {
        Connection connection = null;

        return connection;
    }

}
