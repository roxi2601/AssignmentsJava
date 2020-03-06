package Assignment1.view.display;
import Assignment1.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class DisplayViewController {
    @FXML
    Label HotOrCold;

    @FXML
    LineChart lineChart;

    private XYChart.Data red = new XYChart.Data(0.0,0.0);
    private XYChart.Data orange = new XYChart.Data(0.0,0.0);
    private XYChart.Data green = new XYChart.Data(0.0,0.0);


    private XYChart.Series redSeries = new XYChart.Series();
    private XYChart.Series orangeSeries = new XYChart.Series();
    private XYChart.Series greenSeries = new XYChart.Series();

    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, DisplayViewModel dvm)
    {
        this.viewHandler=viewHandler;
        HotOrCold.textProperty().bind(dvm.hotOrColdProperty());

        red.YValueProperty().bind(dvm.t1Property());
        orange.YValueProperty().bind(dvm.t2Property());
        red.XValueProperty().bind(dvm.timeProperty());
        orange.XValueProperty().bind(dvm.timeProperty());
        green.XValueProperty().bind(dvm.timeProperty());

        redSeries.setName("Thermometer1");
        redSeries.getData().add(red);
        lineChart.getData().add(redSeries);

        orangeSeries.setName("Thermometer2");
        orangeSeries.getData().add(orange);
        lineChart.getData().add(orangeSeries);

        greenSeries.setName("Outside Thermometer");
        greenSeries.getData().add(green);
        lineChart.getData().add(greenSeries);
    }

    @FXML
    public void onBackButton(ActionEvent actionEvent) throws Exception {
        viewHandler.openControlView();
    }
}
