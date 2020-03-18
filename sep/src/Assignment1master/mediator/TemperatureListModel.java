package Assignment1master.mediator;

import Assignment1master.model.Temperature.Temperature;
import Assignment1master.model.radiator.Radiator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TemperatureListModel {
    private ArrayList<Temperature> temperatures;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Radiator radiator = new Radiator(support);

    public TemperatureListModel(){temperatures = new ArrayList<>();}

    public void addTemperature(){
        Temperature temp;
        if (temperatures.size()==0) {
            temp = new Temperature(radiator,0,0);}
        else {
            Temperature last = temperatures.get(temperatures.size()-1);
            temp = new Temperature(radiator,last.getTemperature1(),last.getTemperature2());}
        temp.setTime(temperatures.size()*3);
        temperatures.add(temp);
        support.firePropertyChange("TemperatureAdded",null,temperatures);
    }

    public String warning() {
        Temperature last = temperatures.get(temperatures.size()-1);
        String warning = " ";
        if(last.getTemperature1() > 30 || last.getTemperature2()>30)
        {
            warning ="Temperature in the room is too high";
        }
        else if(last.getTemperature1() <10 || last.getTemperature2()<10)
        {
            warning = "Temperature in the room is too low";
        }

        support.firePropertyChange("warning"," ",warning);
        return warning;
    }

    public void turnUpRadiator() throws InterruptedException {
        int oldPower = radiator.getPower();
        radiator.turnUp();
        support.firePropertyChange("Radiator turned up",oldPower,radiator.getPower());
    }
    public void turnDownRadiator() {
        int oldValue =  radiator.getPower();
        radiator.turnDown();
        support.firePropertyChange("Radiator turned down",oldValue,radiator.getPower());
    }
    public int getRadiatorPower()
    {
        return radiator.getPower();
    }


     public void addListener(String name, PropertyChangeListener listener) {
        support.addPropertyChangeListener(name,listener);
    }
}
