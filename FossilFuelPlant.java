public class FossilFuelPlant extends EnergySource {
    
    public FossilFuelPlant(double capacity, double efficiency, String locationType, double carbonPerMWh) {
        super(capacity, efficiency, locationType, carbonPerMWh);
    }

    @Override
    public double generateEnergy(Weather weather) {
        return capacity * 24 * efficiency;
    }

    @Override
    public boolean FossilBackup() {
        return true;
    }
}
