public class ParkingLot {
    private final Level[] levels;
    private static final int BUSCAP = 1;
    private static final int CARCAP = 100;
    private static final int MOTOCAP = 100;

    // methods
    public ParkingLot(int num) {
        levels = new Level[num];
        for (int i = 0; i < num; i++) {
            levels[i] = new Level(i, BUSCAP, CARCAP, MOTOCAP); // design[][] → BQ
        }
    }

    public boolean canPark(Vehicle v) {
        for (Level lev : levels) {
            if (lev.canPark(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean goPark(Vehicle v) {
        if (!canPark(v)) return false;
        for (Level lev : levels) {
            if (lev.canPark(v)) { // bad → return lev.goPark(v);
                lev.goPark(v);
                return true;
            }
        }
        return false;
    }

}
