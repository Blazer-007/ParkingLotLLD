package com.example.blazer.parkinglot;

import com.example.blazer.parkinglot.enums.VehicleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    private ParkingLot parkingLot;

    @BeforeEach
    void setUp() {
        parkingLot = new ParkingLot("PL-1", 2, 4);
    }

    @Test
    void testConstructor() {
        assertEquals("PL-1", parkingLot.getId());
        assertEquals(2, parkingLot.getNumOfFloors());
        assertEquals(4, parkingLot.getNumOfSlotsPerFloor());
        assertEquals(2, parkingLot.getFloors().size());
        assertEquals(4, parkingLot.getFloors().get(0).size());
    }

    @Test
    void testParkVehicle() {
        String ticket = parkingLot.parkVehicle(VehicleType.CAR);
        assertNotEquals("", ticket);
        assertTrue(ticket.startsWith("PL-1_"));
    }

    @Test
    void testParkVehicleFull() {
        // Fill all slots
        for (int i = 0; i < 8; i++) {
            parkingLot.parkVehicle(VehicleType.CAR);
        }

        // Now try to park another vehicle
        String ticket = parkingLot.parkVehicle(VehicleType.CAR);
        assertEquals("", ticket); // No parking available
    }

}
