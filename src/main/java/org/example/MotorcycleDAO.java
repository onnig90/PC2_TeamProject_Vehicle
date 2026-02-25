package org.example;

import java.sql.*;

public class MotorcycleDAO {
    public static void insertMotorcycle(Motorcycle motorcycle) throws SQLException {
        String INSERT_VEHICLE_SQL = "insert into vehicle(vin, year, mileage, price, available) values (?, ?, ?, ?, ?)";
        String INSERT_MOTO_SQL = "insert into motorcycle(motoMake, motoModel, hasSideCar, forkLength) values (?, ?, ?, ?);" +
                "select motoID from motorcycle where motoMake = ? and motoModel = ?";
        String INSERT_MOTOVEHICLE_SQL = "insert into motorcyclevehicle(vin, motoID) values (?, ?)";

        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement psVehicle = connection.prepareStatement(INSERT_VEHICLE_SQL);
                PreparedStatement psMotorcycle = connection.prepareStatement(INSERT_MOTO_SQL, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement psMotorcycleVehicle = connection.prepareStatement(INSERT_MOTOVEHICLE_SQL)
        ) {
            // insert into Vehicle table
            psVehicle.setString(1, motorcycle.getVin());
            psVehicle.setInt(2, motorcycle.getYear());
            psVehicle.setInt(3, motorcycle.getMileage());
            psVehicle.setDouble(4, motorcycle.getPrice());
            psVehicle.setBoolean(5, motorcycle.getIsAvailable());

            psVehicle.executeUpdate();

            // insert into Motorcycle table
            // insert motorcycle sql
            psMotorcycle.setString(1, motorcycle.getMake());
            psMotorcycle.setString(2, motorcycle.getModel());
            psMotorcycle.setBoolean(3, motorcycle.getHasSidecar());
            psMotorcycle.setDouble(4, motorcycle.getForkLength());
            // select id sql
            psMotorcycle.setString(5, motorcycle.getMake());
            psMotorcycle.setString(6, motorcycle.getModel());

            boolean isMotorcycleAdded = true;
            try {
                psMotorcycle.executeUpdate();
            } catch (SQLException e) {
                isMotorcycleAdded = false;
            }

            int motorcycleId;
            try (ResultSet rs = psMotorcycle.getGeneratedKeys()) {
                if (rs.next()) {
                    motorcycleId = rs.getInt(1);
                } else {
                    if (!isMotorcycleAdded) {
                        motorcycleId = rs.getInt("motoId");
                    } else {
                        connection.rollback();
                        throw new SQLException("Failed to get the Motorcycle ID");
                    }
                }
            }

            // insert into MotorcycleVehicle table
            psMotorcycleVehicle.setString(1, motorcycle.getVin());
            psMotorcycleVehicle.setInt(2, motorcycleId);

            psMotorcycleVehicle.executeUpdate();

            // commit on server
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
