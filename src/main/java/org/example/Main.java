package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Vehicle Management System...");

        // --- Read from files and create objects ---
        ArrayList<Car> carList = FileReaderCSV.loadCarsFromCSV("src/main/resources/CSV_Car.csv");
        ArrayList<Motorcycle> motorcycleList = FileReaderCSV.loadMotorcyclesFromCSV("src/main/resources/CSV_Motorcycle.csv");

        // --- Display item information in the console ---
        System.out.println("\n--- Loaded Cars ---");
        if (carList.isEmpty()) {
            System.out.println("No cars were loaded. Check your cars.csv file.");
        } else {
            for (Car car : carList) {
                System.out.println("Category: " + car.getCategory() + 
                                   " | VIN: " + car.vin + 
                                   " | Make: " + car.make + 
                                   " | Model: " + car.model);
            }
        }

        System.out.println("\n--- Loaded Motorcycles ---");
        if (motorcycleList.isEmpty()) {
            System.out.println("No motorcycles were loaded. Check your motorcycles.csv file.");
        } else {
            for (Motorcycle moto : motorcycleList) {
                System.out.println("Category: " + moto.getCategory() + 
                                   " | VIN: " + moto.vin + 
                                   " | Make: " + moto.make + 
                                   " | Model: " + moto.model);
            }
        }

        // --- Save objects into the database ---
        System.out.println("\n--- Database Saving ---");
        System.out.println("Ready to connect to the database...");
        
        // DBUtil.insertCars(carList);
        // DBUtil.insertMotorbikes(motorbikeList);
    }
}