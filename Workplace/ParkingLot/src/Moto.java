class Moto extends Vehicle {
    // fields
    private Type type;
    // methods
    public Moto() {
        this.type = Type.MOTO;
    }

    @Override
    public Type getType() {
        return this.type;
    }
}
