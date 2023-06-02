public class Main {
    public static void main(String[] args) {
        int num = 1;
        Bus bus1 = new Bus();
        Bus bus2 = new Bus();
        Car car = new Car();
        Moto moto = new Moto();
        ParkingLot parkinglot = new ParkingLot(num);


        boolean res2 = parkinglot.canPark(bus2);
        boolean res1 = parkinglot.canPark(bus1);
        boolean res4 = parkinglot.goPark(bus2);
        boolean res3 = parkinglot.goPark(bus1);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }
}