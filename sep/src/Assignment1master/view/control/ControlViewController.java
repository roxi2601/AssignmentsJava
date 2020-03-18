package Assignment1master.view.control;
import Assignment1master.core.ViewHandler;
import Assignment1master.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class ControlViewController {

    @FXML
    Label stateLabel;
    private ControlViewModel controlViewModel;
    private ViewHandler viewHandler;


    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.viewHandler = viewHandler;
        controlViewModel = viewModelFactory.getControlViewModel();
        stateLabel.textProperty().bindBidirectional(controlViewModel.stateProperty());
        stateLabel.textProperty().set(0 + "");
    }
    @FXML
    public void onUpButton() throws InterruptedException
    {
        controlViewModel.turnUpRadiator();
        stateLabel.textProperty().set(controlViewModel.getRadiatorPower()+"");
    }
    @FXML
    public void onDownButton() {
        controlViewModel.turnDownRadiator();
        stateLabel.textProperty().set(controlViewModel.getRadiatorPower()+"");
    }


    public void onDisplayButton() {
        viewHandler.openDisplayView();
    }
}
