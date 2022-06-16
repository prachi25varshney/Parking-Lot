package parkinglot;

import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ParkingFloor {
    String floorId;
    Map<ParkingSpaceType, Deque<ParkingSpace>> parkingSpaces;

    ParkingFloor(String floorId) {
        this.floorId = floorId;
        parkingSpaces.put(ParkingSpaceType.CAR, new ConcurrentLinkedDeque());
        parkingSpaces.put(ParkingSpaceType.LARGE, new ConcurrentLinkedDeque());
        parkingSpaces.put(ParkingSpaceType.ELECTRIC, new ConcurrentLinkedDeque());
        parkingSpaces.put(ParkingSpaceType.EBIKE, new ConcurrentLinkedDeque());
        parkingSpaces.put(ParkingSpaceType.MOTORBIKE, new ConcurrentLinkedDeque());
        parkingSpaces.put(ParkingSpaceType.HANDICAPPED, new ConcurrentLinkedDeque());
    }

    public boolean isFull() {
        boolean isFull = false;
        for (Map.Entry<ParkingSpaceType, Deque<ParkingSpace>> entry : parkingSpaces.entrySet()) {
            isFull = entry.getKey().getTotalSlots() == entry.getValue().size();
        }
        return isFull;
    }

    public boolean canPark(VehicleType vehicleType) {
        ParkingSpaceType parkingSpaceType = vehicleType.getParkingSpaceType();
        return parkingSpaceType.getTotalSlots() == parkingSpaces.get(parkingSpaceType).size();
    }

    public ParkingSpace getParkingSpace(VehicleType vehicleType) {
        ParkingSpaceType parkingSpaceType = vehicleType.getParkingSpaceType();
        if (parkingSpaceType.getTotalSlots() == parkingSpaces.get(parkingSpaceType).size())
            return null;
        String spotId = parkingSpaces.get(parkingSpaceType).size() + 1 + "";
        ParkingSpace space = new ParkingSpace(this.floorId, spotId, parkingSpaceType);
        space.setAvailability(SpaceAvailability.FULL);
        return space;
    }
}
