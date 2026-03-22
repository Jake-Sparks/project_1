public class EnergyReport {
    protected double totalEnergy;
    protected double totalCarbon;
    protected boolean fossilUsed;
    protected double excessEnergy; 
    protected boolean blackoutOccurred;
    protected double renewableUsed;
    protected double fossilUsedEnergy;

    public EnergyReport(double totalEnergy, double totalCarbon, boolean fossilUsed, double excessEnergy, boolean blackoutOccurred, double renewableUsed, double fossilUsedEnergy) {
        this.totalEnergy = totalEnergy;
        this.totalCarbon = totalCarbon;
        this.fossilUsed = fossilUsed;
        this.excessEnergy = excessEnergy;
        this.blackoutOccurred = blackoutOccurred;
        this.renewableUsed = renewableUsed;
        this.fossilUsedEnergy = fossilUsedEnergy;
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

    public boolean isBlackoutOccurred() {
        return blackoutOccurred;
    }

    public double getRenewableUsed() {
        return renewableUsed;
    }

    public double getFossilUsedEnergy() {
        return fossilUsedEnergy;
    }
}