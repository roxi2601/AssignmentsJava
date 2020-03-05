package Assignment1.view.control;
import Assignment1.core.ViewHandler;
import Assignment1.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import Assignment1.viewmodel.control.ControlViewModel;


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
    public void onUpButton(ActionEvent actionEvent) throws InterruptedException
    {
        controlViewModel.turnUpRadiator();
        stateLabel.textProperty().set(controlViewModel.getRadiatorPower()+"");
    }
    @FXML
    public void onDownButton(ActionEvent actionEvent) {
        controlViewModel.turnDownRadiator();
        stateLabel.textProperty().set(controlViewModel.getRadiatorPower()+"");
    }


    public void onDisplayButton(ActionEvent actionEvent) {
        viewHandler.openDisplayView();
    }
}
