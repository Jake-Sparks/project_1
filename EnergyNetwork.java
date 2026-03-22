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

    public EnergyReport collectEnergyWithCarbon(Weather weather) {
        double totalEnergy = 0;
        double totalCarbon = 0;

        for (EnergySource source:energySources) {
            if (!source.FossilBackup()) {
                double energy = source.generateEnergy(weather);
                totalEnergy += energy;
                totalCarbon += energy * source.getCarbonPerMWh();
            }
        }

        return new EnergyReport(totalEnergy, totalCarbon, false, 0);
    }

    public EnergyReport balanceEnergy(double totalEnergy, double totalCarbon, double demand) {
        sortStorage();
        boolean fossilUsed = false;
        double excessEnergy = 0;

        if (totalEnergy > demand) {
            double excess = totalEnergy - demand;

            for (EnergyStorage storage:storageSystems) {
                excess = storage.storeEnergy(excess);
                if (excess <= 0) break;
            }

            if (excess > 0) {
                excessEnergy = excess;
            }
        } 
        else if (totalEnergy < demand) {

            double needed = demand - totalEnergy;

            // this uses storage
            for (EnergyStorage storage:storageSystems) {
                needed = storage.releaseEnergy(needed);
                if (needed <= 0) {
                    break;
                }
            }

            // use fossil if still needed
            if (needed > 0) {
                for (EnergySource source:energySources) {
                    if (source.FossilBackup()) {
                        double fossilEnergy = source.generateEnergy(null);
                        fossilUsed = true;

                        if (fossilEnergy >= needed) {
                            totalEnergy += needed;
                            totalCarbon += needed * source.getCarbonPerMWh();
                            needed = 0;
                            break;
                        } else {
                            totalEnergy += fossilEnergy;
                            totalCarbon += fossilEnergy * source.getCarbonPerMWh();
                            needed -= fossilEnergy;
                        }
                    }
                }
            }

            // if there is still not enough energy produced, then we will have a blackout
            if (needed > 0) {
                System.out.println("----BLACKOUT----- Not enough energy even with fossil backup");
            }
        }

        return new EnergyReport(totalEnergy, totalCarbon, fossilUsed, excessEnergy);
    }

    // Here bubble sort is used because it's a small dataset size and for simplicity
    private void sortStorage() {
        for (int i = 0; i < storageSystems.size(); i++) {
            for (int j = 0; j < storageSystems.size() - 1; j++) {
                EnergyStorage current = storageSystems.get(j);
                EnergyStorage next = storageSystems.get(j + 1);

                if (current.getPriority() > next.getPriority()) {
                    storageSystems.set(j, next);
                    storageSystems.set(j + 1, current);
                }
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