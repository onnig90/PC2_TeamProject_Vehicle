package org.example;

import java.sql.*;

public final class DBUtil {
    public static Connection getConnection() throws SQLException {
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        if (url == null || user == null || password == null) {
            throw new IllegalStateException("DB environment variables are not set");
        }

        return DriverManager.getConnection(url, user, password);
    }
}