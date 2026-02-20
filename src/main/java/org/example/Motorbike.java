package org.example;

import org.example.Vehicle;

public class Motorbike extends Vehicle {

    private boolean hasSidecar;
    private double forkLength;

    public Motorbike(int vin, String make, String model, int year, int mileage, double price, boolean hasSidecar, double forkLength) {
        super(vin, make, model, year, mileage, price);
        this.hasSidecar = hasSidecar;
        this.forkLength = forkLength;
    }
    @Override
    public String getCategory() {
        return "Motorbike";
    }
}