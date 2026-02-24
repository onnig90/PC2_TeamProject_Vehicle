package org.example;

public class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    // FIX: Removed the invalid enum line
    private double forkLength;

    public Motorcycle(String vin, String make, String model, int year, int mileage, double price, boolean hasSidecar, double forkLength) {
        super(vin, make, model, year, mileage, price);
        this.hasSidecar = hasSidecar;
        this.forkLength = forkLength;
    }

    @Override
    public String getCategory() {
        return "Motorcycle";
    }
}