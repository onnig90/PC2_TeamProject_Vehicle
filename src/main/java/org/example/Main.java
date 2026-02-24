package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Vehicle Management System...");

        // --- Read from files and create objects ---
        // (Make sure you actually create files named "cars.csv" and "motorcycles.csv" in your project folder!)
        List<Car> carList = FileReaderCSV.loadCarsFromCSV("cars.csv");
        List<Motorcycle> motorcycleList = FileReaderCSV.loadMotorcyclesFromCSV("motorcycles.csv");


        // --- Display item information in the console ---
        System.out.println("\n--- Loaded Cars ---");
        if (carList.isEmpty()) {
            System.out.println("No cars were loaded. Check your cars.csv file.");
        } else {
            for (Car car : carList) {
                // Accessing the protected variables inherited from Vehicle
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
        System.out.println("Connecting to Database... (Code for this is coming next!)");
        
        // We will call your DBUtil methods here once we build them
        // DBUtil.insertCars(carList);
        // DBUtil.insertMotorcycles(motorcycleList);
    }
}