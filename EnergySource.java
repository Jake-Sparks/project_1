public abstract class EnergySource {
    
    protected double capacity;
    protected double efficiency;
    protected String locationType;
    protected double carbonPerMWh;

    public EnergySource(double capacity, double efficiency, String locationType, double carbonPerMWh) {
        this.capacity = capacity;
        this.efficiency = efficiency;
        this.locationType = locationType;
        this.carbonPerMWh = carbonPerMWh;
    }

    public abstract double generateEnergy(Weather weather);

    public boolean FossilBackup() {
        return false;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public double getCarbonPerMWh() {
        return carbonPerMWh;
    }
}