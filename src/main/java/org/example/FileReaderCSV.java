package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FileReaderCSV {

    // --- READ CARS ---
    public static List<Car> loadCarsFromCSV(String filePath) {
        List<Car> carList = new ArrayList<>();
        
        // Using "Try-with-resources" to automatically close the file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the CSV line by commas
                String[] data = line.split(",");
                // Parse the array into a Car object
                Car newCar = parseCar(data);
                
                // If parsing was successful, add it to our List
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
    public static List<Motorcycle> loadMotorcyclesFromCSV(String filePath) {
        List<Motorcycle> motoList = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Motorcycle newMoto = parseMotorcycle(data);
                
                if (newMoto != null) {
                    motoList.add(newMoto);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the motorcycle file: " + e.getMessage());
        }
        return motoList;
    }

    // --- PARSING HELPER: CAR ---
    private static Car parseCar(String[] data) {
        try {
            // Inherited from Vehicle
            int vin = Integer.parseInt(data[0].trim()); 
            String make = data[1].trim();
            String model = data[2].trim();
            int year = Integer.parseInt(data[3].trim());
            int mileage = Integer.parseInt(data[4].trim());
            double price = Double.parseDouble(data[5].trim());
            
            // Car specific properties
            int doorCount = Integer.parseInt(data[6].trim());
            double trunkCapacity = Double.parseDouble(data[7].trim());
            boolean hasAirConditioning = Boolean.parseBoolean(data[8].trim());

            return new Car(vin, make, model, year, mileage, price, doorCount, trunkCapacity, hasAirConditioning);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.err.println("Invalid data format for Car row: " + Arrays.toString(data));
            return null; 
        }
    }

    // --- PARSING HELPER: MOTORCYCLE ---
    private static Motorcycle parseMotorcycle(String[] data) {
        try {
            // Inherited from Vehicle
            int vin = Integer.parseInt(data[0].trim()); 
            String make = data[1].trim();
            String model = data[2].trim();
            int year = Integer.parseInt(data[3].trim());
            int mileage = Integer.parseInt(data[4].trim());
            double price = Double.parseDouble(data[5].trim());
            
            // Motorcycle specific properties
            boolean hasSidecar = Boolean.