public class Car extends Vehicle{
    private Type type;

    public Car() {
        this.type = Type.CAR;
    }

    @Override
    public Type getType() {
        return this.type;
    }


}