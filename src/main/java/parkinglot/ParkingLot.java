package parkinglot;

import java.util.List;

public class ParkingLot {

    String parkingLotId;
    Address address;
    List<ParkingFloor> parkingFloors;
    List<EntranceGate> entranceGateList;
    List<ExitGate> exitGateList;

    public boolean isFull() {
        boolean isFull = false;
        for (ParkingFloor parkingFloor : parkingFloors) {
            isFull = isFull || parkingFloor.isFull();
        }
        return isFull;
    }

    public boolean canPark(VehicleType vehicleType) {
        boolean canPark = true;
        for (ParkingFloor floor : parkingFloors) {
            canPark = floor.canPark(vehicleType);
            if (canPark) break;
        }
        return canPark;
    }

    public ParkingSpace getParkingSpace(VehicleType vehicleType) {
        return new ParkingSpace();
    }

    public ParkingSpace vacateParkingSpace(String parkingSpaceId) {
        return new ParkingSpace();
    }
}
