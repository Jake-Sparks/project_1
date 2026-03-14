public abstract class EnergySource {
    
    protected double capacity;
    protected double efficiency;
    protected String locationType;

    public EnergySource(double capacity, double efficiency, String locationType) {
        this.capacity = capacity;
        this.efficiency = efficiency;
        this.locationType = locationType;
    }

    public abstract double generateEnergy(Weather weather);

    public double getCapacity() {
        return capacity;
    }

    public double getEfficiency() {
        return efficiency;
    }
}