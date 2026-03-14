import java.util.Random;

public class City {
    private int population;
    private double averageConsumption;
    private Random rand;

    public City(int population, double averageConsumption) {
        this.population = population;
        this.averageConsumption = averageConsumption;
        rand = new Random();
    }

    public double getDailyDemand() {

        double baseDemand = (population * averageConsumption) / 1000.0;

        // demand can fluctuate 30% less or more per day
        double fluctuation = 0.8 + rand.nextDouble() * 0.4;
        return baseDemand * fluctuation;
    }

    public int getPopulation() {
        return population;
    }

    public double getAverageConsumption() {
        return averageConsumption;
    }
}
