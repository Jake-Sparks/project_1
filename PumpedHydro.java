public class PumpedHydro extends EnergyStorage {
    public PumpedHydro(double capacity) {
        super(capacity, 0.8, 2);
        name = "Pumped Hydro Storage";
    }
}
