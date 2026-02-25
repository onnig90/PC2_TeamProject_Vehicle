package org.example;

import java.sql.*;

public class CarDAO {
    public static void insertCar(Car car) throws SQLException {
        String INSERT_VEHICLE_SQL = "insert into vehicle(vin, year, mileage, price, available) values (?, ?, ?, ?, ?)";
        String INSERT_CAR_SQL = "insert into car(carMake, carModel, doorCount, trunkCap, hasAirConditioning) values (?, ?, ?, ?, ?);" +
                "select carID from car where carMake = ? and carModel = ?";
        String INSERT_CARVEHICLE_SQL = "insert into carvehicle(vin, carID) values (?, ?)";

        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement psVehicle = connection.prepareStatement(INSERT_VEHICLE_SQL);
                PreparedStatement psCar = connection.prepareStatement(INSERT_CAR_SQL, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement psCarVehicle = connection.prepareStatement(INSERT_CARVEHICLE_SQL)
        ) {
            // insert into Vehicle table
            psVehicle.setString(1, car.getVin());
            psVehicle.setInt(2, car.getYear());
            psVehicle.setInt(3, car.getMileage());
            psVehicle.setDouble(4, car.getPrice());
            psVehicle.setBoolean(5, car.getIsAvailable());

            psVehicle.executeUpdate();

            // insert into Car table
            // insert car sql
            psCar.setString(1, car.getMake());
            psCar.setString(2, car.getModel());
            psCar.setInt(3, car.getDoorCount());
            psCar.setDouble(4, car.getTrunkCapacity());
            psCar.setBoolean(5, car.getHasAirConditioning());
            // select id sql
            psCar.setString(6, car.getMake());
            psCar.setString(7, car.getModel());

            boolean isCarAdded = true;
            try {
                psCar.executeUpdate();
            } catch (SQLException e) {
                isCarAdded = false;
            }

            int carId;
            try (ResultSet rs = psCar.getGeneratedKeys()) {
                if (rs.next()) {
                    carId = rs.getInt(1);
                } else {
                    if (!isCarAdded) {
                        carId = rs.getInt("carId");
                    } else {
                        connection.rollback();
                        throw new SQLException("Failed to get the Car ID");
                    }
                }
            }

            // insert into CarVehicle table
            psCarVehicle.setString(1, car.getVin());
            psCarVehicle.setInt(2, carId);

            psCarVehicle.executeUpdate();

            // commit on server
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
