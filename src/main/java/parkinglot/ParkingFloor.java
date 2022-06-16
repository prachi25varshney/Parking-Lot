package parkinglot;

import java.util.List;
import java.util.Map;

public class ParkingFloor {
    String floorId;
    Map<ParkingSpaceType,List<ParkingSpace>> parkingSpaces;

    public boolean isFull() {
        boolean isFull = false;
        for(Map.Entry<ParkingSpaceType,List<ParkingSpace>>  entry: parkingSpaces.entrySet()){
            isFull = entry.getKey().getTotalSlots() == entry.getValue().size();
        }
        return isFull;
    }
}
