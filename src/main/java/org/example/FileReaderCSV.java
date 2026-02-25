package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileReaderCSV {
    // --- READ CARS ---
    public static ArrayList<Car> loadCarsFromCSV(String filePath) {
        ArrayList<Car> carList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // <--- SKIPS THE HEADER ROW
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Car newCar = parseCar(data);

                if (newCar != null) {
                    carList.add(newCar);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the car file: " + e.getMessage());
        }
        return carList;
    }

    // --- READ MOTORCYCLES ---
    public static ArrayList<Motorcycle> loadMotorcyclesFromCSV(String filePath) {
        ArrayList<Motorcycle> motorcycleList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // <--- SKIPS THE HEADER ROW
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Motorcycle newMoto = parseMotorcycle(data);

                if (newMoto != null) {
                    motorcycleList.add(newMoto);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the motorcycle file: " + e.getMessage());
        }
        return motorcycleList;
    }

    // --- PARSING HELPER: CAR ---
    private static Car parseCar(String[] data) {
        try {
            String vin = data[0].trim();
            String make = data[1].trim();
            String model = data[2].trim();
            int year = Integer.parseInt(data[3].trim());
            int mileage = Integer.parseInt(data[4].trim());
            double price = Double.parseDouble(data[5].trim());
            boolean available = Boolean.parseBoolean(data[6].trim());
            int doorCount = Integer.parseInt(data[7].trim());
            double trunkCapacity = Double.parseDouble(data[8].trim());
            boolean hasAirConditioning = Boolean.parseBoolean(data[9].trim());

            return new Car(vin, make, model, year, mileage, price, available, doorCount, trunkCapacity, hasAirConditioning);
        } catch (Exception e) {
            System.err.println("Invalid data format for Car row: " + Arrays.toString(data));
            return null;
        }
    }

    // --- PARSING HELPER: MOTORCYCLE ---
    private static Motorcycle parseMotorcycle(String[] data) {
        try {
            String vin = data[0].trim();
            String make = data[1].trim();
            String model = data[2].trim();
            int year = Integer.parseInt(data[3].trim());
            int mileage = Integer.parseInt(data[4].trim());
            double price = Double.parseDouble(data[5].trim());
            boolean available = Boolean.parseBoolean(data[6].trim());
            boolean hasSidecar = Boolean.parseBoolean(data[7].trim());
            double forkLength = Double.parseDouble(data[8].trim());

            return new Motorcycle(vin, make, model, year, mileage, price, available, hasSidecar, forkLength);
        } catch (Exception e) {
            System.err.println("Invalid data format for Motorcycle row: " + Arrays.toString(data));
            return null;
        }
    }
}