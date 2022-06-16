package parkinglot;

import java.util.List;

public class ParkingLot {

    String parkingLotId;
    Address address;
    List<ParkingFloor> parkingFloors;
    List<EntranceGate> entranceGateList;
    List<ExitGate> exitGateList;

    public boolean isFull(){
        boolean isFull = false;
        for(ParkingFloor parkingFloor : parkingFloors){
            isFull = isFull || parkingFloor.isFull();
        }
        return isFull;
    }
    public boolean canPark(VehicleType vehicleType){ return true;}
    public ParkingSpace getParkingSpace(VehicleType vehicleType){ return new ParkingSpace();}
    public ParkingSpace vacateParkingSpace(String parkingSpaceId){ return  new ParkingSpace();}
}
