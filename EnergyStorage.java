public abstract class EnergyStorage {

    protected double capacity;
    protected double currentEnergy;
    protected double efficiency;
    protected String name;

    public EnergyStorage(double capacity, double efficiency) {
        this.capacity = capacity;
        this.efficiency = efficiency;
        this.currentEnergy = 0;
    }

    public double storeEnergy(double energy) {

        double storedEnergy = energy * efficiency;
        double energySpace = capacity - currentEnergy;

        if (storedEnergy <= energySpace) {
            currentEnergy += storedEnergy;
            return 0;
        }
        else {
            currentEnergy = capacity;
            return storedEnergy - energySpace;
        }
    }

    public double releaseEnergy(double neededEnergy) {

        if (currentEnergy >= neededEnergy) {
            currentEnergy -= neededEnergy;
            return 0;
        }
        else {
            double remaining = neededEnergy - currentEnergy;
            currentEnergy = 0;
            return remaining;
        }
    }

    public String toString() {
        return name + ": " + currentEnergy + " / " + capacity + " MWh";
    }

    public double getCurrentEnergy() {
        return currentEnergy;
    }

    public double getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }
}