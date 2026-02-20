package org.example;

public abstract class Vehicle {

    protected int vin;
    protected String make;
    protected String model;
    protected int year;
    protected int mileage;
    protected double price;
    protected boolean available;

    public Vehicle(int vin, String make, String model, int year,
                   int mileage, double price) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.available = true;

    }
    public void markSold() {
        available = false;
    }
    public abstract String getCategory();
}
