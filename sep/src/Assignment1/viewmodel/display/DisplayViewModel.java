package Assignment1.viewmodel.display;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Assignment1.mediator.TemperatureModel;
import javafx.scene.chart.XYChart;

public class DisplayViewModel
{

    //line chart fields
    private StringProperty kurs05 = new SimpleStringProperty();
    private StringProperty kurs10 = new SimpleStringProperty();
    private List<KursContainer> kurser05;
    private List<KursContainer> kurser10;
    private XYChart.Series dataSeries05 = new XYChart.Series();
    private XYChart.Series dataSeries10 = new XYChart.Series();
    private DoubleProperty upperBound = new SimpleDoubleProperty();
    private DoubleProperty lowerBound = new SimpleDoubleProperty();
    //line chart fields

    private TemperatureModel model;
    private StringProperty warning;

    public DisplayViewModel(TemperatureModel model, KursWatcherModel model) {
        this.model = model;
        warning = new SimpleStringProperty();

        //line chart
        kurser05 = model.getKurser05();
        kurser10 = model.getKurser10();
        upperBound.set(0);lowerBound.set(105);
        model.addListener("NewKurs05", this::onNew05Kurs);
        model.addListener("NewKurs10", this::onNew10Kurs);
        model.addListener("Kurs05Update", propertyChangeEvent-> onKursUpdate(propertyChangeEvent, kurs05));
        model.addListener("Kurs10Update", propertyChangeEvent -> onKursUpdate(propertyChangeEvent, kurs10));
    }




    public StringProperty hotOrColdProperty() {
        //this method watches the diagram if any parameter is too high or too low it updates the label saying that there is too hot or too cold
        warning.set(model.warning());
        return warning;
    }
}
