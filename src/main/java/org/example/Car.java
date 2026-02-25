package org.example;

public class Car extends Vehicle {
    private int doorCount;
    private double trunkCapacity;
    private boolean hasAirConditioning;

    public Car(String vin, String make, String model, int year, int mileage, double price, boolean available,
               int doorCount, double trunkCapacity, boolean hasAirConditioning) {
        super(vin, make, model, year, mileage, price, available);
        this.doorCount = doorCount;
        this.trunkCapacity = trunkCapacity;
        this.hasAirConditioning = hasAirConditioning;
    }

    @Override
    public String getCategory() {
        return "Car";
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public double getTrunkCapacity() {
        return trunkCapacity;
    }

    public void setTrunkCapacity(double trunkCapacity) {
        this.trunkCapacity = trunkCapacity;
    }

    public boolean getHasAirConditioning() {
        return hasAirConditioning;
    }

    public void setHasAirConditioning(boolean hasAirConditioning) {
        this.hasAirConditioning = hasAirConditioning;
    }

    public void openTrunk() {
        System.out.println("Trunk opened. Capacity: " + trunkCapacity + " cubic feet");
    }
}