package parkinglot;

public class ParkingSpace {
    private String spaceId;
    private String floorId;
    private ParkingSpaceType parkingSpaceType;
    private SpaceAvailability availability;

    ParkingSpace(String floorId, String spaceId, ParkingSpaceType parkingSpaceType) {
        this.floorId = floorId;
        this.spaceId = spaceId;
        this.parkingSpaceType = parkingSpaceType;
        availability = SpaceAvailability.VACANT;
    }

    public void setAvailability(SpaceAvailability availability) {
        this.availability = availability;
    }
}
