package Assignment1.viewmodel.display;

import javafx.beans.property.StringProperty;
import Assignment1.mediator.TemperatureModel;

public class DisplayViewModel {
    private TemperatureModel temperatureModel;
    private StringProperty hotCold;
    public DisplayViewModel(TemperatureModel model) {
        this.temperatureModel=model;
    }

    public StringProperty hotOrColdProperty() {
        return hotCold;
    }
}
