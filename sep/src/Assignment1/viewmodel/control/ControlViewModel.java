package Assignment1.viewmodel.control;

import Assignment1.model.radiator.RadiatorState;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Assignment1.mediator.TemperatureModel;

public class ControlViewModel {

    private StringProperty state;

    public ControlViewModel(TemperatureModel model) {

        state = new SimpleStringProperty();
        model.addListener("Temperatures",this:: );
    }
    public StringProperty stateProperty() {
        return state;
    }

    public RadiatorState getRadiatorState(TemperatureModel model)
    {
        model.getTemperatureValues(HERE WE NEED INT RADIATOR STATE);
    }
    public void turnUpButton() {
    }
    public void turnDownButton() {
    }
}
