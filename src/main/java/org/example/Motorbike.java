package org.example;

public class Motorbike extends Vehicle {
    private boolean hasSidecar;
    private double forkLength;

    // Changed vin from int to String
    public Motorbike(String vin, String make, String model, int year, int mileage, double price, boolean hasSidecar, double forkLength) {
        super(vin, make, model, year, mileage, price);
        this.hasSidecar = hasSidecar;
        this.forkLength = forkLength;
    }

    @Override
    public String getCategory() {
        return "Motorbike";
    }
}