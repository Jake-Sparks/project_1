import java.util.Random;

public class Weather {
    private double sunHours;
    private double sunIntensity;  
    private double windSpeed;
    private Random rand;

    public Weather() {
        rand = new Random();

        // if sun intensity is 0 (no sunlight whatsoever) if it's 1 (pure sunlight) unrealistic that is between 0-0.2 or so (max-min = 0.7)
        sunIntensity = 0.3 + rand.nextDouble() * 0.7;
        // if windSpeed was 0, turbines would generate almost nothing (unrealistic for simulation), (max-min = 18)
        windSpeed = 2 + rand.nextDouble() * 18;
        // (7-3 = 4) average sun hours a day is 4-7 hours
        sunHours = 3 + rand.nextDouble() * 4;
    }

    public double getSunHours() {
        return sunHours;
    }

    public double getSunIntensity() {
        return sunIntensity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }


}
