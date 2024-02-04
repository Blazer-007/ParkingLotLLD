package com.example.blazer.parkinglot.model;

import com.example.blazer.parkinglot.enums.VehicleType;

public class Vehicle {
    private VehicleType type;
    private String regNo;
    private String color;

    public Vehicle(VehicleType type, String regNo, String color) {
        this.type = type;
        this.regNo = regNo;
        this.color = color;
    }

    public VehicleType getType() {
        return type;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Registration Number: " + regNo + " and Color: " + color;
    }
}
