import java.util.ArrayList;

public class EnergyNetwork {

    private ArrayList<EnergySource> energySources;
    private ArrayList<EnergyStorage> storageSystems;

    public EnergyNetwork() {
        energySources = new ArrayList<>();
        storageSystems = new ArrayList<>();
    }

    public void addEnergySource(EnergySource source) {
        energySources.add(source);
    }

    public void addStorage(EnergyStorage storage) {
        storageSystems.add(storage);
    }

    public double collectEnergy(Weather weather) {

        double totalEnergy = 0;
        for (int i = 0; i < energySources.size(); i++) {
            totalEnergy += energySources.get(i).generateEnergy(weather);
        }

        return totalEnergy;
    }

    public void balanceEnergy(double totalEnergy, double demand) {

        if (totalEnergy > demand) {
            double excess = totalEnergy - demand;
            for (int i = 0; i < storageSystems.size(); i++) {
                excess = storageSystems.get(i).storeEnergy(excess);

                if (excess <= 0) {
                    break;
                }
            }
            if (excess > 0) {
                System.out.println(excess + " MWh renewable energy wasted due to all storages full");
            }
        }
        else if (totalEnergy < demand) {

            double needed = demand - totalEnergy;
            for (int i = 0; i < storageSystems.size(); i++) {
                needed = storageSystems.get(i).releaseEnergy(needed);

                if (needed <= 0) {
                    break;
                }
            }

            if (needed > 0) {
                System.out.println("---BLACKOUT---There is not enough energy to meet demand");
            }
        }
    }

    public ArrayList<EnergySource> getEnergySources() {
        return energySources;
    }
    
    public ArrayList<EnergyStorage> getStorageSystems() {
        return storageSystems;
    } 
}