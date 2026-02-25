package org.example;

public abstract class Vehicle {
    protected String vin; // Changed to String
    protected String make;
    protected String model;
    protected int year;
    protected int mileage;
    protected double price;
    protected boolean available;

    public Vehicle(String vin, String make, String model, int year, int mileage, double price) { // Changed int to String
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.available = true; 
    }

    public void markSold() {
        this.available = false;
    }

    public abstract String getCategory();
}