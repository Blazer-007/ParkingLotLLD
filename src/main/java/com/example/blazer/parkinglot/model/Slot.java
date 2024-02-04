package com.example.blazer.parkinglot.model;

import com.example.blazer.parkinglot.enums.VehicleType;

public class Slot {
    private VehicleType vehicleType;
    private boolean available;

    public Slot(VehicleType vehicleType, boolean available) {
        this.vehicleType = vehicleType;
        this.available = available;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
