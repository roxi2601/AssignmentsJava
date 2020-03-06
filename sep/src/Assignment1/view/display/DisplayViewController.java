package Assignment1.view.display;
import Assignment1.core.ViewHandler;
import Assignment1.core.ViewModelFactory;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DisplayViewController {
    @FXML
    Label HotOrCold;

    @FXML
    LineChart lineChart;

    private XYChart.Data t1 = new XYChart.Data(0.0,0.0);
    private XYChart.Data t2 = new XYChart.Data(0.0,0.0);

    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, DisplayViewModel dvm)
    {
        this.viewHandler=viewHandler;
        HotOrCold.textProperty().bind(dvm.hotOrColdProperty());
        t1.YValueProperty().bind(dvm.t1Property());
        t2.YValueProperty().bind(dvm.t2Property());
        t1.XValueProperty().bind(dvm.timeProperty());
        t2.XValueProperty().bind(dvm.timeProperty());

        XYChart.Series redSeries = new XYChart.Series();
        redSeries.setName("T1");
        redSeries.getData().add(t1);
        lineChart.getData().add(redSeries);

        XYChart.Series orangeSeries = new XYChart.Series();
        orangeSeries.setName("T2");
        orangeSeries.getData().add(t2);
        lineChart.getData().add(orangeSeries);

    }
    public LineChart getLineChart(){return lineChart;}

    @FXML
    public void onBackButton(ActionEvent actionEvent) throws Exception {
        viewHandler.openControlView();
    }
}
