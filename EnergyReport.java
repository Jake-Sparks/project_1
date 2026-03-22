public class EnergyReport {
    protected double totalEnergy;
    protected double totalCarbon;

    public EnergyReport(double totalEnergy, double totalCarbon) {
        this.totalEnergy = totalEnergy;
        this.totalCarbon = totalCarbon;
    }

    public double getTotalEnergy() {
        return totalEnergy;
    }

    public double getTotalCarbon() {
        return totalCarbon;
    }
}