package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement("select id, name, age, breed from dogs");
                ResultSet rs = ps.executeQuery()
        ) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}