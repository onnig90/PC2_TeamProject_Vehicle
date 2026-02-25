package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FileReaderCSV {

    public static List<Car> loadCarsFromCSV(String filePath) {
        List<Car> carList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // <--- SKIPS THE HEADER ROW
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Car newCar = parseCar(data);
                if (newCar != null) carList.add(newCar);
            }
        } catch (IOException e) {
            System.err.println("Error reading the car file: " + e.getMessage());
        }
        return carList;
    }

    public static List<Motorbike> loadMotorbikesFromCSV(String filePath) {
        List<Motorbike> motorbikeList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // <--- SKIPS THE HEADER ROW
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Motorbike newMoto = parseMotorbike(data);
                if (newMoto != null) motorbikeList.add(newMoto);
            }
        } catch (IOException e) {
            System.err.println("Error reading the motorbike file: " + e.getMessage());
        }
        return motorbikeList;
    }

    private static Car parseCar(String[] data) {
        try {
            String vin = data[0].trim(); // Changed to String
            String make = data[1].trim();
            String model = data[2].trim();
            int year = Integer.parseInt(data[3].trim());
            int mileage = Integer.parseInt(data[4].trim());
            double price = Double.parseDouble(data[5].trim());
            
            // Index 6 is the "available" boolean, so we skip to 7
            int doorCount = Integer.parseInt(data[7].trim());
            double trunkCapacity = Double.parseDouble(data[8].trim());
            boolean hasAirConditioning = Boolean.parseBoolean(data[9].trim());

            return new Car(vin, make, model, year, mileage, price, doorCount, trunkCapacity, hasAirConditioning);
        } catch (Exception e) { // Changed to general Exception to catch array out of bounds too
            System.err.println("Invalid data format for Car row: " + Arrays.toString(data));
            return null; 
        }
    }

    private static Motorbike parseMotorbike(String[] data) {
        try {
            String vin = data[0].trim(); // Changed to String
            String make = data[1].trim();
            String model = data[2].trim();
            int year = Integer.parseInt(data[3].trim());
            int mileage = Integer.parseInt(data[4].trim());
            double price = Double.parseDouble(data[5].trim());
            
            // Index 6 is the "available" boolean, so we skip to 7
            boolean hasSidecar = Boolean.parseBoolean(data[7].trim());
            double forkLength = Double.parseDouble(data[8].trim());

            return new Motorbike(vin, make, model, year, mileage, price, hasSidecar, forkLength);
        } catch (Exception e) {
            System.err.println("Invalid data format for Motorbike row: " + Arrays.toString(data));
            return null; 
        }
    }
}