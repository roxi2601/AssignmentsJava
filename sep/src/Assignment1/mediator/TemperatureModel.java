package Assignment1.mediator;

import Assignment1.model.radiator.OffState;
import Assignment1.model.radiator.Radiator;
import Assignment1.model.thermometer.Thermometer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModel implements Model
{
    private double temperature1;
    private double temperature2;
    private double time;
    private Radiator radiator;
    private Thermometer thermometer1;
    private Thermometer thermometer2;

    private PropertyChangeSupport support;

    public TemperatureModel()
    {
        temperature1 = 0;
        temperature2 = 0;
        time = 0;
        thermometer1 = new Thermometer(1,"t1",temperature1);
        thermometer2 = new Thermometer(7,"t2",temperature2);

        support =  new PropertyChangeSupport(this);

        radiator = new Radiator(support);

    }

    public double getTime()
    {
        double temp = time;
        time = time+3;
        support.firePropertyChange("time",temp,time);
        return time;
    }


      public double calcTemp1()
    {
        double temp = thermometer1.temperature(temperature1,getRadiatorPower(),1,0,3);
        support.firePropertyChange("t1",temperature1,temp);
        temperature1 = temp;
        return temp;

    }
    public double calcTemp2()
    {
        double temp = thermometer2.temperature(temperature2,getRadiatorPower(),7,0,3);
        support.firePropertyChange("t2",temperature2,temp);
        temperature2 = temp;
        return temp;
    }
    public void turnUpRadiator() throws InterruptedException
    {
        int oldPower = radiator.getPower();
        radiator.turnUp();
        support.firePropertyChange("Radiator turned up",oldPower,radiator.getPower());
    }
    public void turnDownRadiator()
    {
        int oldValue =  radiator.getPower();
        radiator.turnDown();
        support.firePropertyChange("Radiator turned down",oldValue,radiator.getPower());
    }
    public int getRadiatorPower()
    {
        return radiator.getPower();
    }
    public void updateState()
    {
        int pwr =  radiator.getPower();

    }
    public String warning()
    {
        String warning = " ";
        if(calcTemp1() > 30 || calcTemp2()>30)
        {
            warning ="Temperature in the room is too high";
        }
        else if(calcTemp2()<10 || calcTemp1()<10)
        {
            warning = "Temperature in the room is too low";
        }

        support.firePropertyChange("warning"," ",warning);
        return warning;

    }


    //adding and removing listeners:

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

