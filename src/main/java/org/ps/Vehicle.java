package org.ps;

public class Vehicle {
    private String make;
    private String model;
    private int year;
    private String color;
    private int mileage;
    private int price;
    private String type;

    public Vehicle(String make, String model, int year, String color, int mileage, int price, String type) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return make + " " + model + " (" + year + "), Color: " + color + ", Mileage: " + mileage + " miles, Price: $" + price + ", Type: " + type;
    }
}
