package com.example.blazer.parkinglot;

import com.example.blazer.parkinglot.enums.VehicleType;
import com.example.blazer.parkinglot.model.Slot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String id;
    private int numOfFloors;
    private int numOfSlotsPerFloor;
    private List<List<Slot>> floors;

    public ParkingLot(String id, int numOfFloors, int numOfSlotsPerFloor) {
        this.id = id;
        this.numOfFloors = numOfFloors;
        this.numOfSlotsPerFloor = numOfSlotsPerFloor;
        this.floors = new ArrayList<>();
        addFloors(numOfFloors);
    }

    public void addFloor() {
        this.floors.add(createFloorSlots(this.numOfSlotsPerFloor));
    }

    private void addFloors(int cntOfFloors) {
        for (int cnt = 0 ; cnt < cntOfFloors ; cnt++) {
            addFloor();
        }
    }


    private List<Slot> createFloorSlots(int numOfSlots) {
        List<Slot> floor = new ArrayList<>();
        floor.add(new Slot(VehicleType.TRUCK, true));
        floor.add(new Slot(VehicleType.BIKE, true));
        floor.add(new Slot(VehicleType.BIKE, true));
        for (int cnt = 3 ; cnt < numOfSlots ; cnt++) {
            floor.add(new Slot(VehicleType.CAR, true));
        }
        return floor;
    }

    public String parkVehicle(VehicleType vehicleType) {
        for (int floorNo = 0 ; floorNo < numOfFloors ; floorNo++) {
            int slotNo = findSlot(floorNo, vehicleType);
            if (slotNo == -1)
                continue;
            return createTicketId(floorNo + 1, slotNo + 1);
        }
        return "";
    }

    public void unParkVehicle(String ticketId) {
        List<Integer> floorAndSlot = getFloorAndSlot(ticketId);
        Slot slot = floors.get(floorAndSlot.get(0)).get(floorAndSlot.get(1));
        slot.setAvailable(true);
    }

    private int findSlot(int floorNo, VehicleType vehicleType) {
        List<Slot> floor = floors.get(floorNo);
        for (int slotNo = 0 ; slotNo < floor.size() ; slotNo++) {
            Slot slot = floor.get(slotNo);
            if (slot.getVehicleType() == vehicleType && slot.isAvailable()) {
                slot.setAvailable(false);
                return slotNo;
            }
        }
        return -1;
    }

    private String createTicketId(int floorNo, int slotNo) {
        StringBuilder sb = new StringBuilder(id);
        sb.append("_");
        sb.append(floorNo);
        sb.append("_");
        sb.append(slotNo);
        return sb.toString();
    }

    private List<Integer> getFloorAndSlot(String ticketId) {
        String[] ticket = ticketId.split("_");
        return List.of(
                Integer.parseInt(ticket[1]) - 1,
                Integer.parseInt(ticket[2]) - 1
        );
    }

    public String getId() {
        return id;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public int getNumOfSlotsPerFloor() {
        return numOfSlotsPerFloor;
    }

    public List<List<Slot>> getFloors() {
        return floors;
    }
}
