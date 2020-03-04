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
        //this method watches the diagram if any parameter is too high or too low it updates the label saying that there is too hot or too cold
        return hotCold;
    }
}
