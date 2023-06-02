public class Bus extends Vehicle{
    private Type type;

    public Bus() {
        this.type = Type.BUS;
    }
    @Override
    public Type getType() {
        return this.type;
    }


}
