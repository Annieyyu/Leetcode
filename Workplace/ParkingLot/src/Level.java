public class Level {


    // fields
    private final int floor;
    private final ParkingSpot[] spots;

    // methods
    public Level(int floor, int busCap, int carCap, int motoCap) {
        this.floor = floor;
        spots = new ParkingSpot[busCap + carCap + motoCap];
        for(int i = 0; i < spots.length; i++) {
            if (i < busCap) {
                spots[i] = new ParkingSpot(Type.BUS);
            }
            else if (i >= busCap && i < busCap + carCap) {
                spots[i] = new ParkingSpot(Type.CAR);
            }
            else {
                spots[i] = new ParkingSpot(Type.MOTO);
            }
        }
    }
    public boolean canPark(Vehicle v) {
        // cc
        for (ParkingSpot spot : spots) {
            if (spot.canPark(v)) {
                return true;
            }
        }
        return false;
    }
    public boolean goPark(Vehicle v) {
        // cc
        if (!canPark(v)) {
            return false;
        }
        for (ParkingSpot spot: spots) {
            if (spot.canPark(v)) { // not good way → return spot.goPark(v) // wrong
                spot.goPark(v);
                return true;
            }
        }
        return false; // compiler vs currency
    }
    public int numOfAvailableSpot(Vehicle v) {
        int count = 0;
        for (ParkingSpot spot : spots) {
            if (spot.canPark(v)) {
                count++;
            }
        }
        return count;
    }
}
