package Assignment1.mediator;

import Assignment1.model.thermometer.Thermometer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModel implements Model
{
    private double temperature1;
    private double temperature2;

    private Thermometer thermometer1;
    private Thermometer thermometer2;

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public TemperatureModel()
    {
        this.temperature1 = 0;
        this.temperature2 = 0;
        thermometer1 = new Thermometer(1,"t1",temperature1);
        thermometer2 = new Thermometer(7,"t2",temperature2);
    }

    public double calcTemp1(int radiatorPower)
    {
        double temp = thermometer1.temperature(temperature1,radiatorPower,1,0,3);
        temperature1 = temp;
        return temp;
    }
    public double calcTemp2(int radiatorPower)
    {
        double temp = thermometer2.temperature(temperature2,radiatorPower,7,0,3);
        temperature2 = temp;
        return temp;
    }

    @Override public double[] getTemperatureValues(int radiatorPower)
    //this method returns values which will be used in Assignment1.view Assignment1.model to fill the line chart
    {
        return new double[] {calcTemp1(radiatorPower),calcTemp2(radiatorPower)};
    }
    @Override public void addListener(String name,
                                      PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(name,listener);
    }

    @Override public void addPropertyListener(PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(listener);
    }

    @Override public void addPropertyListener(String eventName,
                                              PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override public void removePropertyListener(PropertyChangeListener listener)
    {
        removePropertyListener(listener);
    }

    @Override public void removePropertyListener(String eventName,
                                                 PropertyChangeListener listener)
    {
        removePropertyListener(eventName, listener);
    }
}

