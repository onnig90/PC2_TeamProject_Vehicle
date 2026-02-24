package org.example;

import java.sql.*;

public class CarDAO {
    public static void insertCar(Car car) throws SQLException {
        String INSERT_VEHICLE_SQL = "insert into vehicle(vin, year, mileage, price, available) values (?, ?, ?, ?, ?)";
        String INSERT_CAR_SQL = "insert into car(carMake, carModel, doorCount, trunkCap, hasAirConditioning) values (?, ?, ?, ?, ?)";
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
            psCar.setString(1, car.getMake());
            psCar.setString(2, car.getModel());
            psCar.setInt(3, car.getDoorCount());
            psCar.setDouble(4, car.getTrunkCapacity());
            psCar.setBoolean(5, car.getHasAirConditioning());

            psCar.executeUpdate();

            int carId;
            try(ResultSet rs = psCar.getGeneratedKeys()) {
                if(rs.next()) {
                    carId = rs.getInt(1);
                } else {
                    throw new SQLException("Failed to get the car ID");
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
