public class BatteryStorage extends EnergyStorage {
    
    public BatteryStorage(double capacity) {
        super(capacity, 0.95);
        name = "Battery Storage";
    }
}
