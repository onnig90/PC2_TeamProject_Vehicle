package org.example;

public class Car extends Vehicle {
    private int doorCount;
    private double trunkCapacity;
    private boolean hasAirConditioning;

    // Changed vin from int to String
    public Car(String vin, String make, String model, int year, int mileage, double price, int doorCount, double trunkCapacity, boolean hasAirConditioning) {
        super(vin, make, model, year, mileage, price);
        this.doorCount = doorCount;
        this.trunkCapacity = trunkCapacity;
        this.hasAirConditioning = hasAirConditioning;
    }

    @Override
    public String getCategory() {
        return "Car";
    }

    public void openTrunk() {
        System.out.println("Trunk opened. Capacity: " + trunkCapacity + " cubic feet");
    }
}