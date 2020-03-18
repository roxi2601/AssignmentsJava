package Assignment1master.view.display;

import Assignment1master.model.Temperature.Temperature;
import Assignment1master.mediator.TemperatureListModel;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;


public class DisplayViewModel
{
    private TemperatureListModel model;
    private StringProperty warning;
    private ObservableList<XYChart.Series<Double, Double>> chart;

    private XYChart.Series<Double, Double> red = new XYChart.Series<Double, Double>();
    private XYChart.Series<Double, Double> orange = new XYChart.Series<Double, Double>();
    private XYChart.Series<Double, Double> green = new XYChart.Series<Double, Double>();

    public DisplayViewModel(TemperatureListModel model) {
        red.setName("Thermometer1");
        orange.setName("Thermometer2");
        green.setName("outside thermometer");
        this.model = model;
        warning = new SimpleStringProperty();
        model.addListener("warning", evt -> updateWarning());
        chart = FXCollections.observableArrayList();
        model.addListener("TemperatureAdded", this::update);

        chart.addAll(red,orange,green);
    }

    public void update(PropertyChangeEvent evt){
        Platform.runLater(()->{
            ArrayList<Temperature> temps= (ArrayList<Temperature>)evt.getNewValue();
            for(int j=temps.size()-1;j<temps.size();j++){
                red.getData().add(new XYChart.Data(temps.get(j).getTime(),temps.get(j).getTemperature1()));
                orange.getData().add(new XYChart.Data(temps.get(j).getTime(),temps.get(j).getTemperature2()));
                green.getData().add(new XYChart.Data(temps.get(j).getTime(),0));
            }

        });
    }

    public void updateWarning() {
        Platform.runLater(()->{
            String warn = model.warning();
            warning.set(warn);
        });
    }

    public StringProperty hotOrColdProperty() {
        return warning;
    }

    public ObservableList<XYChart.Series<Double, Double>> getChart(){return chart;}
}
