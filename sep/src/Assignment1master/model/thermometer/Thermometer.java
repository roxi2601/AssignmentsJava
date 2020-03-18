package Assignment1master.model.thermometer;

public class Thermometer
{
    private String id;
    private double temperature;
    private int distance;

    public Thermometer(int distance, String id, double temperature)
    {
        this.id = id;
        this.temperature = temperature;
        this.distance = distance;
    }

    public double temperature(double temperature, int radiatorPower, int distance, double outDoor, int timeFrame)
    {
        double tMax = Math.min(11 * radiatorPower + 10, 11 * radiatorPower + 10 + outDoor);
        tMax = Math.max(Math.max(temperature, tMax), outDoor);
        double heaterTerm = 0;
        if (radiatorPower > 0)
        {
            double den = Math.max((tMax * (20 - 5 * radiatorPower) * (distance + 5)), 0.1);
            heaterTerm = 30 * timeFrame * Math.abs(tMax - temperature) / den;
        }
        double outdoorTerm = (temperature - outDoor) * timeFrame / 250.0;
        temperature = Math.min(Math.max(temperature - outdoorTerm + heaterTerm, outDoor), tMax);
        if (temperature<0.1){return 0;}
        return temperature;
    }

}


