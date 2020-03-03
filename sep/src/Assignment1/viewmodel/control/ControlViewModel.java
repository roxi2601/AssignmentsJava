package Assignment1.viewmodel.control;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Assignment1.mediator.TemperatureModel;

public class ControlViewModel {

    private StringProperty state;
    private StringProperty hotOrCold;
    public ControlViewModel(TemperatureModel model) {

        state = new SimpleStringProperty();
        hotOrCold=new SimpleStringProperty();
        model.addListener("Temperatures", );
    }

    public StringProperty stateProperty() {
        return state;
    }

    public void turnUpButton() {

    }

    public void turnDownButton() {

    }
    public int getRadiatorState()
    {
        return radiatorState.get();
    }
}
