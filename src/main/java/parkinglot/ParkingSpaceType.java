package parkinglot;

public enum ParkingSpaceType {
    HANDICAPPED(10),
    CAR(10),
    LARGE(10),
    MOTORBIKE(10),
    ELECTRIC(10),
    EBIKE(10);

    private int totalSlots;

    ParkingSpaceType(int totalSlots){
        this.totalSlots = totalSlots;
    }
    public int getTotalSlots() {
        return totalSlots;
    }
}
