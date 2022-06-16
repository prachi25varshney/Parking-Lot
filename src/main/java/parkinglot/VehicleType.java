package parkinglot;

public enum VehicleType {
    CAR(ParkingSpaceType.CAR),
    TRUCK(ParkingSpaceType.LARGE),
    ELECTRIC(ParkingSpaceType.ELECTRIC),
    HANDICAPPED(ParkingSpaceType.HANDICAPPED),
    MOTORBIKE(ParkingSpaceType.MOTORBIKE),
    EBIKE(ParkingSpaceType.EBIKE);

    private ParkingSpaceType parkingSpaceType;

    VehicleType(ParkingSpaceType parkingSpaceType) {
        this.parkingSpaceType = parkingSpaceType;
    }

    public ParkingSpaceType getParkingSpaceType() {
        return parkingSpaceType;
    }
}
