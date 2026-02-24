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

    public boolean getHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    public double getForkLength() {
        return forkLength;
    }

    public void setForkLength(double forkLength) {
        this.forkLength = forkLength;
    }
}