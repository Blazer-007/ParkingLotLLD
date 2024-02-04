package com.example.blazer.parkinglot;

import com.example.blazer.parkinglot.model.Vehicle;

import java.util.HashMap;

public class ParkingManager {

    private HashMap<String, Vehicle> parkedVehicles;

    private ParkingLot parkingLot;

    public ParkingManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        parkedVehicles = new HashMap<>();
    }

    public void parkVehicle(Vehicle vehicle) {
        String ticketId = parkingLot.parkVehicle(vehicle.getType());
        if (ticketId.isBlank() || ticketId.isEmpty()) {
            System.out.println("Parking Lot Full");
            return;
        }
        System.out.println("Parked vehicle. Ticket ID: " + ticketId);
    }

    public void unParkVehicle(String ticketId) {
        if (parkedVehicles.containsKey(ticketId)) {
            System.out.println("Unparked vehicle with " + parkedVehicles.get(ticketId));
            parkedVehicles.remove(ticketId);
            parkingLot.unParkVehicle(ticketId);
            return;
        }
        System.out.println("Invalid Ticket");
    }
}
