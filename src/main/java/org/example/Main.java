package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Vehicle Management System...");

        // --- Read from files and create objects ---
        List<Car> carList = FileReaderCSV.loadCarsFromCSV("cars.csv");
        List<Motorbike> motorbikeList = FileReaderCSV.loadMotorbikesFromCSV("motorbikes.csv");

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

        System.out.println("\n--- Loaded Motorbikes ---");
        if (motorbikeList.isEmpty()) {
            System.out.println("No motorbikes were loaded. Check your motorbikes.csv file.");
        } else {
            for (Motorbike moto : motorbikeList) {
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