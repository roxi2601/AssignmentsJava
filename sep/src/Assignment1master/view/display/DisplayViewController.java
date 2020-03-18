package Assignment1master.view.display;
import Assignment1master.core.ViewHandler;
import Assignment1master.model.Temperature.Temperature;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
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

    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, DisplayViewModel dvm)
    {
        this.viewHandler=viewHandler;
        HotOrCold.textProperty().bind(dvm.hotOrColdProperty());

        lineChart.setData(dvm.getChart());
    }

    @FXML
    public void onBackButton(){
        viewHandler.openControlView();
    }
}
