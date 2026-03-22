public class EnergyReport {
    protected double totalEnergy;
    protected double totalCarbon;
    protected boolean fossilUsed;
    protected double excessEnergy; 

    public EnergyReport(double totalEnergy, double totalCarbon, boolean fossilUsed, double excessEnergy) {
        this.totalEnergy = totalEnergy;
        this.totalCarbon = totalCarbon;
        this.fossilUsed = fossilUsed;
        this.excessEnergy = excessEnergy;
    }
    
    public double getTotalEnergy() {
        return totalEnergy;
    }

    public double getTotalCarbon() {
        return totalCarbon;
    }

    public boolean isFossilUsed() {
        return fossilUsed;
    }

    public double getExcessEnergy() {
        return excessEnergy;
    }
}