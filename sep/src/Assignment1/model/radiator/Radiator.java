package Assignment1.model.radiator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Radiator {
    private RadiatorState currentState;
    private PropertyChangeSupport support;

    public Radiator(PropertyChangeSupport support){
        this.support = support;
        currentState = new OffState();
    }

    public void turnUp() throws InterruptedException {
        currentState.turnUp(this);
    }

    public void turnDown() {
        currentState.turnDown(this);
    }

    public int getPower() {
        return currentState.getPower();
    }

    public void setPowerState(RadiatorState state) {
        RadiatorState oldState = currentState;
        this.currentState = state;
        support.firePropertyChange("state",oldState,currentState);
    }
    public void addListener(PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(listener);
    }
}
