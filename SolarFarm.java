public class SolarFarm extends EnergySource {

    public SolarFarm(double capacity, double efficiency, String locationType) {
        super(capacity, efficiency, locationType);
    }

    @Override
    public double generateEnergy(Weather weather) {

        double sunIntensity = weather.getSunIntensity();
        double sunHours = weather.getSunHours();

        double energyProduced = capacity * sunHours * sunIntensity * efficiency;

        return energyProduced;
    }
}