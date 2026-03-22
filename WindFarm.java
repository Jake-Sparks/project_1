import java.util.Random;

public class WindFarm extends EnergySource {

    private int numberOfTurbines;
    private double turbineCapacity;
    private Random rand;

    public WindFarm(double efficiency, String locationType, int numberOfTurbines, double turbineCapacity, double carbonPerMWh) {

        super(numberOfTurbines * turbineCapacity, efficiency, locationType, carbonPerMWh);

        this.numberOfTurbines = numberOfTurbines;
        this.turbineCapacity = turbineCapacity;
        this.rand = new Random();
    }

    @Override
    public double generateEnergy(Weather weather) {
        double windSpeed = weather.getWindSpeed();

        // if the wind farm is off shore, there is a 20% increase in wind
        if (locationType.equals("offshore")) {
            windSpeed = windSpeed * 1.2;
        }

        // all turbines have a 5% chance to be offline, thus would need repairing or engineering work
        int failedTurbines = 0;

        for (int i = 0; i < numberOfTurbines; i++) {
            if (rand.nextDouble() < 0.05) {
                failedTurbines += 1;
            }
        }

        int workingTurbines = numberOfTurbines - failedTurbines;
        double workingCapacity = workingTurbines * turbineCapacity;

        // 
        double output;
        if (windSpeed < 3) {
            output = 0;
        }
        else if (windSpeed < 12) {
            output = workingCapacity * (windSpeed / 12);
        }
        else if (windSpeed < 25) {
            output = workingCapacity;
        }
        else {
            output = 0;
        }

        double energy = output * 24;

        return energy;
    }
}