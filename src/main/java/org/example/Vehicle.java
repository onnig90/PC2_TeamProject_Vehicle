package org.example;

public abstract class Vehicle {
    protected String vin;
    protected String make;
    protected String model;
    protected int year;
    protected int mileage;
    protected double price;
    protected boolean available;

    public Vehicle(String vin, String make, String model, int year, int mileage, double price, boolean available) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.available = available;
    }

    public void markSold() {
        this.available = false;
    }

    public abstract String getCategory();

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getIsAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

