package com.example.blazer.parkinglot.model;

public class Ticket {
    private String id;

    private Vehicle vehicle;

    public Ticket(String id, Vehicle vehicle) {
        this.id = id;
        this.vehicle = vehicle;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
