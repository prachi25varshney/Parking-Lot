package parkinglot;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ParkingFloor {
    String floorId;
    Map<ParkingSpaceType, Deque<ParkingSpace>> parkingSpaces = new HashMap<>();
    Map<String, ParkingSpace> usedParkingSpace = new HashMap<>();

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
            isFull = entry.getValue().size() == 0;
        }
        return isFull;
    }

    public boolean canPark(VehicleType vehicleType) {
        ParkingSpaceType parkingSpaceType = vehicleType.getParkingSpaceType();
        return parkingSpaces.get(parkingSpaceType).size() > 0;
    }

    public ParkingSpace getParkingSpace(VehicleType vehicleType) {
        ParkingSpaceType parkingSpaceType = vehicleType.getParkingSpaceType();
        if (parkingSpaceType.getTotalSlots() == parkingSpaces.get(parkingSpaceType).size())
            return null;

        ParkingSpace space = parkingSpaces.get(parkingSpaceType).poll();
        space.setAvailability(SpaceAvailability.FULL);
        usedParkingSpace.put(space.getSpaceId(), space);
        return space;
    }

    public ParkingSpace vacateParkingSpace(String parkingSpaceId) {
        ParkingSpace space = usedParkingSpace.remove(parkingSpaceId);
        if (space != null) {
            space.setAvailability(SpaceAvailability.VACANT);
            parkingSpaces.get(space.getParkingSpaceType()).addFirst(space);
            return space;
        }
        return null;
    }
}
