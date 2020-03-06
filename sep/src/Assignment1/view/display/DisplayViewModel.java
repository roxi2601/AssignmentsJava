package Assignment1.view.display;

import javafx.application.Platform;
import javafx.beans.property.*;
import Assignment1.mediator.TemperatureModel;
import javafx.beans.value.ObservableValue;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class DisplayViewModel
{
    private TemperatureModel model;
    private StringProperty warning;
    private DoubleProperty t1;
    private DoubleProperty t2;
    private DoubleProperty time;

    public DisplayViewModel(TemperatureModel model) {
        this.model = model;
        warning = new SimpleStringProperty();
        model.addListener("warning", evt -> updateWarning());
        t1 = new SimpleDoubleProperty();
        t2 = new SimpleDoubleProperty();
        time = new SimpleDoubleProperty();
        model.addListener("temperatures", evt -> updateTemperatures());
    }

    public void updateTemperatures(){
        Platform.runLater(()->{
        t1.set(model.calcTemp1());
        t2.set(model.calcTemp2());
        time.set(model.getTime());
        });
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

    public DoubleProperty t1Property(){return t1;}
    public DoubleProperty t2Property(){return t2;}
    public DoubleProperty timeProperty(){return time;}
}
