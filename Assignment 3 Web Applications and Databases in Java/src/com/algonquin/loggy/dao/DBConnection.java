package com.algonquin.loggy.dao;

import java.sql.Connection;

public class DBConnection {

    // Database Schema
    // CREATE DATABASE loggy DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
    // CREATE TABLE logs (uuid CHAR(40) NOT NULL PRIMARY KEY, title CHAR(128),
    // content TEXT, createTimestamp Date);

    private static final String dbUser = "root";
    private static final String dbPassword = "";

    public static Connection getConnectionToDatabase() {
        Connection connection = null;

        return connection;
    }

}
