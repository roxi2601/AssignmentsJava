package Assignment1.mediator;
import Assignment1.PropertyChangeSubject;

import java.beans.PropertyChangeListener;

public interface Model extends PropertyChangeSubject
{
    double[] getTemperatureValues(int radiatorPower);
    void addListener(String name, PropertyChangeListener listener);
}
