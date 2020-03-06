package Assignment1.view.display;

import javafx.application.Platform;
import javafx.beans.property.*;
import Assignment1.mediator.TemperatureModel;
import javafx.beans.value.ObservableValue;

import java.beans.PropertyChangeEvent;


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
        model.addListener("t1", evt -> updateTemperature1(evt));
        t2 = new SimpleDoubleProperty();
        model.addListener("t2",evt -> updateTemperature2(evt));
        time = new SimpleDoubleProperty();
        model.addListener("time",evt -> updateTime(evt));
    }

    public void updateTemperature1(PropertyChangeEvent evt){
        Platform.runLater(()->{
            double val = (double)evt.getNewValue();
            t1.setValue(val);
        });
    }
    public void updateTemperature2(PropertyChangeEvent evt){
        Platform.runLater(()->{
            double val = (double)evt.getNewValue();
            t2.setValue(val);
        });
    }
    public void updateTime(PropertyChangeEvent evt){
        Platform.runLater(()->{
            double val = (double)evt.getNewValue();
            time.setValue(val);
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

    public ObservableValue t1Property(){return t1;}
    public ObservableValue t2Property(){return t2;}
    public ObservableValue timeProperty(){return time;}
}
