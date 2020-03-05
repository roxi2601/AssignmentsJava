package Assignment1.viewmodel.display;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Assignment1.mediator.TemperatureModel;


public class DisplayViewModel
{
    private TemperatureModel model;
    private StringProperty warning;

    public DisplayViewModel(TemperatureModel model)
    {
        this.model = model;
        warning = new SimpleStringProperty();
        model.addListener("warning",evt->updateWarning());
    }

    public void updateWarning()
    {
        Platform.runLater(()->{
            String warn = model.warning();
            warning.set(warn);
        });

    }

    public StringProperty hotOrColdProperty() {
        return warning;
    }
}
