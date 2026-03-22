public class SolarFarm extends EnergySource {

    public SolarFarm(double capacity, double efficiency, String locationType, double carbonPerMWh) {
        super(capacity, efficiency, locationType, carbonPerMWh);
    }

    @Override
    public double generateEnergy(Weather weather) {

        double sunIntensity = weather.getSunIntensity();
        double sunHours = weather.getSunHours();

        double energyProduced = capacity * sunHours * sunIntensity * efficiency;

        return energyProduced;
    }
}